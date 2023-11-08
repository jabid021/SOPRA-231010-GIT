package hopital.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;

public class App {


	static IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
	static IDAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	
	static Compte connected=null;
	static boolean pause = false;
	static LinkedList<Patient> fileAttente = new LinkedList();
	static File fichier = new File("fileAttente.txt");



	public static int saisieInt(String message) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println(message);
		return  sc.nextInt();
	}

	public static double saisieDouble(String message) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println(message);
		return  sc.nextDouble();
	}


	public static String saisieString(String message) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println(message);
		return  sc.nextLine();
	}

	public static boolean saisieBoolean(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message+" (true / false)");
		return sc.nextBoolean();
	}



	public static void menuPrincipal() {
		System.out.println("\nMenu principal de l'hopital");
		System.out.println("1- Se connecter");
		System.out.println("2- Stop");
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}
		menuPrincipal();
	}

	public static void seConnecter() {

		String login=saisieString("Saisir login");
		String password = saisieString("Saisir password");
		connected = daoCompte.findByLoginAndPassword(login, password);
		
		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Choisir une salle");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			if(pause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}
	}

	public static void menuSecretaire() {
		System.out.println("\nMenu Secretaire");
		System.out.println("1- Inscription d'un patient");
		System.out.println("2- Afficher les anciennes visites d'un patient");
		System.out.println("3- Afficher l'etat de la file d'attente");
		System.out.println("4- Partir en pause");
		System.out.println("5- Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : inscriptionPatient();break;
		case 2 : afficherVisitesPatient(); ;break;
		case 3 : afficherFileAttente();break;
		case 4 : partirEnPause();break;
		case 5 : connected = null; menuPrincipal();break;
		}
		menuSecretaire();

	}

	public static void inscriptionPatient() {
		int id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);
		if(patient==null) 
		{
			System.out.println("Creation d'un nouveau patient :\n");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			patient = new Patient(id, nom, prenom);
			daoPatient.insert(patient);
			System.out.println("Le patient a été insert en bdd\n");
		}
		fileAttente.add(patient);
		System.out.println(patient.getPrenom()+" "+patient.getNom()+" vient d'etre ajoute dans la file d'attente");
	}

	public static void afficherVisitesPatient() {
		int id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);
		if(patient == null) 
		{
			System.out.println("Ce patient n'existe pas !");
		}
		else 
		{
			List<Visite> visites = daoVisite.findAllByPatient(patient);
			if(visites.isEmpty()) 
			{
				System.out.println("Le patient "+id+" n'a aucune visite");
			}
			for(Visite visite : visites) 
			{
				System.out.println(visite);
			}
		}
		
	}

	public static void afficherFileAttente() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("La file d'attente est vide");
		}
		else 
		{
			for(Patient patient : fileAttente) 
			{
				System.out.println(patient);
			}
			
			if(connected instanceof Medecin) 
			{
				System.out.println("Le prochain patient est : "+fileAttente.peek());
			}
		}	
	}

	public static void partirEnPause() {
		try 
		{
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(fileAttente);
			fileAttente.clear();
			pause=true;

			oos.close();
			fos.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		menuSecretairePause();
	}
	public static void menuSecretairePause() {
		System.out.println("\nMenu Secretaire PAUSE");
		System.out.println("1- Revenir de pause");
		System.out.println("2- Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : revenirPause();;break;
		case 2 : connected=null;menuPrincipal();break;
		}
		menuSecretairePause();
	}

	public static void revenirPause() {

		try 
		{
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			fileAttente= (LinkedList<Patient>) ois.readObject();
			pause=false;

			ois.close();
			fis.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		menuSecretaire();
	}
	public static void menuMedecin() {
		System.out.println("\nMenu Medecin");
		System.out.println("1- Recevoir un patient");
		System.out.println("2- Afficher l'etat de la file d'attente");
		System.out.println("3- Sauvegarder visites");
		System.out.println("4- Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFileAttente();break;
		case 3 : sauvegarderVisite();break;
		case 4 : sauvegarderVisite();connected=null;menuPrincipal();break;
		}
		menuMedecin();
	}

	public static void recevoirPatient() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("La file d'attente est vide");
		}
		else 
		{
			Medecin medecin = (Medecin) connected;
			List<Visite> visites = medecin.getVisites();
			Patient patient = fileAttente.poll();
			Visite visite = new Visite(patient,medecin);
			visites.add(visite);
			System.out.println("Visite créée pour le patient "+patient.getPrenom()+" "+patient.getNom());
			if(visites.size()==3) 
			{
				System.out.println("Vous avez atteint la limite de 3 visites, sauvegarde Auto :");
				sauvegarderVisite();
			}
		}
	}

	public static void sauvegarderVisite() {
		Medecin medecin = (Medecin) connected;
		List<Visite> visites = medecin.getVisites();
		if(visites.isEmpty()) 
		{
			System.out.println("Aucune visite à save...");
		}
		else 
		{
			for(Visite visite : visites) 
			{
				daoVisite.insert(visite);
				System.out.println("Sauvegarde de la visite : "+visite);
			}
			visites.clear();
		}
	}


	public static void main(String[] args) {
	
		// Suppression en cascade des patients et leurs visites 
	/*	Patient p = daoPatient.findById(1);
		System.out.println(daoVisite.findAllByPatient(p));
		daoPatient.delete(1);
		System.out.println(daoVisite.findAllByPatient(p));*/
		menuPrincipal();
	}

}
