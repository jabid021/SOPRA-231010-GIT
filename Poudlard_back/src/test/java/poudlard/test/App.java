package poudlard.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import poudlard.dao.DAOEquipe;
import poudlard.dao.DAOJoueur;
import poudlard.dao.DAOMaison;
import poudlard.dao.DAOMatch;
import poudlard.dao.DAOSorcier;
import poudlard.model.Animal;
import poudlard.model.Eleve;
import poudlard.model.Equipe;
import poudlard.model.Joueur;
import poudlard.model.Maison;
import poudlard.model.Match;
import poudlard.model.Poste;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;


public class App {

	static DAOMaison daoMaison = new DAOMaison();
	static DAOEquipe daoEquipe = new DAOEquipe();
	static DAOMatch daoMatch = new DAOMatch();
	static DAOSorcier daoSorcier = new DAOSorcier();
	static DAOJoueur daoJoueur = new DAOJoueur();
	
	
	static Sorcier connected;

	//-----------------------------------------------------


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


	public static void inscription() {

		String login=saisieString("Saisir login");
		String password = saisieString("Saisir password");
		String prenom=saisieString("Saisir prenom");
		String nom = saisieString("Saisir nom");
		int promotion = saisieInt("Saisir promotion");
		String nomAnimal = saisieString("Saisir le nom du familier");
		String raceAnimal = saisieString("Saisir la race du familier");
		Animal animal = new Animal(nomAnimal,raceAnimal);

		Eleve eleve  = new Eleve(login,password,nom,prenom,promotion,animal,null);

		daoSorcier.insert(eleve);

	}

	public static void seConnecter() {

		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");

		connected = daoSorcier.findByLoginAndPassword(login, password);

		if(connected instanceof Eleve) 
		{
			menuEleve();
		}
		else if(connected instanceof Professeur) 
		{
			menuProfesseur();
		}
		else 
		{
			System.out.println("Identifiants invalides !");
		}

	}

	public static void menuEleve() 
	{
		System.out.println("Menu des Eleves "+connected.getLogin());
		System.out.println("En construction...");
		System.out.println("1- Postuler dans une equipe");
		System.out.println("2 - Se deconnecter");
		int choix = saisieInt("Choisir un menu");
		switch(choix){
		case 1 -> postulerEquipe();
		case 2 -> menuPrincipal();
		}
		menuEleve();	
	}

	public static void postulerEquipe() {
		System.out.println("Voici la liste des equipes : ");
		afficherEquipes();
		
		Integer idEquipe = saisieInt("Quelle equipe rejoindre ?");
		Equipe equipe = daoEquipe.findById(idEquipe);
		
		String poste = saisieString("choisir un poste : "+Arrays.toString(Poste.values())); 
		
		Joueur j1 = new Joueur(false, LocalDate.now(), null, equipe, Poste.valueOf(poste) ); 
		daoJoueur.insert(j1); 
		
			
	}

	public static void menuProfesseur() 
	{
		System.out.println("Menu des Professeurs "+connected.getLogin());

		System.out.println("1 - Gestion des Sorciers");
		System.out.println("2 - Gestion des Maisons");
		System.out.println("3 - Gestion des Equipes");
		System.out.println("4 - Gestion des Joueurs");
		System.out.println("5 - Gestion des Matchs");
		System.out.println("6 - Retour");

		int choix = saisieInt("Choisir un menu");
		switch(choix){
		case 1 -> menuGestionSorciers();
		case 2 -> menuGestionMaisons();
		case 3 -> menuGestionEquipes();
		case 4 -> menuGestionJoueurs();
		case 5 -> menuGestionMatchs();
		case 6 -> menuPrincipal();
		}

		menuProfesseur();
	}


	public static void menuGestionMatchs() {
		System.out.println("Menu Gestion des Matchs");

		System.out.println("1- Afficher les matchs");
		System.out.println("2- Chercher un match");
		System.out.println("3- Ajouter un match");
		System.out.println("4- Modifier un match");
		System.out.println("5- Supprimer un match");
		System.out.println("6- Retour");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherMatchs();break;
		case 2 : rechercheMatchParId();break;
		case 3 : ajouterMatch();break;
		case 4 : modifierMatch();break;
		case 5 : supprimerMatch();break;
		case 6 : menuProfesseur();break;
		}

		menuGestionMatchs();
	}

	public static void modifierMatch() { 
		Integer id=saisieInt("Saisir l'id de la rencontre");
		LocalDate rencontre=LocalDate.parse(saisieString("Saisir la date de la rencontre"));
		LocalTime horaire=LocalTime.parse(saisieString("Saisir l'heure de la rencontre"));
		Equipe domicile=daoEquipe.findById(saisieInt("Saisir l'id de l'équipe domicile"));
		Equipe exterieur=daoEquipe.findById(saisieInt("Saisir l'id de l'équipe extérieure"));

		Match m=new Match(rencontre, horaire, exterieur,domicile);
		m.setId(id);

		String reponseModifScoreDom=saisieString("Voulez-vous saisir le score de l'équipe domicile (y/n)");
		if(reponseModifScoreDom.equals("y")) {
			Integer scoreDom=saisieInt("Saisir le score de l'équipe domicile");
			m.setScoreDom(scoreDom);
		}

		String reponseModifScoreExt=saisieString("Voulez-vous saisir le score de l'équipe extérieure (y/n)");
		if(reponseModifScoreExt.equals("y")) {
			Integer scoreExt=saisieInt("Saisir le score de l'équipe extérieure");
			m.setScoreExt(scoreExt);
		}
		daoMatch.update(m);

	}
	public static void supprimerMatch() {
		afficherMatchs();
		Integer id = saisieInt("Choisir l'id du match");
		daoMatch.delete(id);
	}

	public static void afficherMatchs() {
		List<Match> matches=daoMatch.findAll();
		if(matches.isEmpty()) {
			System.out.println("Aucun match repertorié");
		}
		for (Match m:matches) {
			System.out.println(m);
		}
	}
	public static Match rechercheMatchParId() {
		Integer id=saisieInt("Saisir l'id du match recherché");
		return daoMatch.findById(id);
	}

	public static void ajouterMatch() {
		LocalDate rencontre=LocalDate.parse(saisieString("Saisir la date de la rencontre"));
		LocalTime horaire=LocalTime.parse(saisieString("Saisir l'heure de la rencontre"));
		Equipe domicile=daoEquipe.findById(saisieInt("Saisir l'id de l'équipe domicile"));
		Equipe exterieur=daoEquipe.findById(saisieInt("Saisir l'id de l'équipe extérieure"));
		Match m=new Match(rencontre, horaire, exterieur,domicile);
		daoMatch.insert(m);
	}


	public static void menuGestionJoueurs() {
		System.out.println("Menu Gestion des Joueurs");

		System.out.println("1- Afficher tous les joueurs");
		System.out.println("2- Afficher un joueur");
		System.out.println("3- Ajouter un joueur");
		System.out.println("4- Modifier un joueur");
		System.out.println("5- Supprimer un joueur");
		System.out.println("6 - Retour");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherJoueur();break;
		case 2 : afficherUnJoueur(); break; 
		case 3 : ajouterJoueur();break;
		case 4 : modifierJoueur();break;
		case 5 : supprimerJoueur();break;
		case 6 : menuProfesseur();break;
		}

		menuGestionJoueurs();
	}
	
	

	public static void supprimerJoueur() {
		afficherJoueur(); 
		int id = saisieInt("saisir un id à supprimer"); 
		daoJoueur.delete(id); 
	}
	public static void modifierJoueur() {
		afficherJoueur(); 
		int id = saisieInt("saisir l'id du joueur à modifier"); 
		boolean capitaine = saisieBoolean("Le joueur est-il capitaine ? (true/false)"); 
		String admission = saisieString("date d'admission");
		String poste = saisieString("choisir un poste : "+Arrays.toString(Poste.values())); 
		afficherEleves();
		int id1 = saisieInt("saisir l'di d'un élève"); 
		Eleve e1 = (Eleve) daoSorcier.findById(id1); 
		afficherEquipes(); 
		id = saisieInt("saisir l'id d'une equipe"); 
		Equipe eq1= daoEquipe.findById(id); 
		Joueur j1 = new Joueur(id, capitaine, LocalDate.parse(admission), e1, eq1, Poste.valueOf(poste) ); 
		daoJoueur.update(j1); 
		
	}
	public static void afficherUnJoueur() {
		int id = saisieInt("saisir l'id du joueur");
		
		Joueur j = daoJoueur.findById(id); 
		if (j==null) {
			System.out.println("le joueur n'existe pas");
			
		}
		else {
			System.out.println(j);
		}
	}
	public static void afficherJoueur() {
		List<Joueur> joueurs = daoJoueur.findAll(); 
		if (joueurs.isEmpty()) {
			System.out.println("il n'y a pas de joueurs dans la base");
		}

		for(Joueur j : joueurs) {
			System.out.println(j);

		}

	}

	public static void ajouterJoueur() {
		boolean capitaine = saisieBoolean("Le joueur est-il capitaine ? (true/false)"); 
		String admission = saisieString("date d'admission");
		String poste = saisieString("choisir un poste : "+Arrays.toString(Poste.values())); 
		afficherEleves();
		int id = saisieInt("saisir l'di d'un élève"); 
		Eleve e1 = (Eleve) daoSorcier.findById(id); 
		afficherEquipes(); 
		id = saisieInt("saisir l'id d'une equipe"); 
		Equipe eq1= daoEquipe.findById(id); 
		Joueur j1 = new Joueur(capitaine, LocalDate.parse(admission), e1, eq1, Poste.valueOf(poste) ); 
		daoJoueur.insert(j1); 
		
	}


	public static void menuGestionEquipes() {
		System.out.println("Menu Gestion des Equipes");
		System.out.println("1- Afficher toutes les Equipes");
		System.out.println("2- Ajouter une Equipe");
		System.out.println("3- Modifier une Equipe");
		System.out.println("4- Supprimer une Equipe");
		System.out.println("5 - Retour");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherEquipes();break;
		case 2 : ajouterEquipe();break;
		case 3 : modifierEquipe();break;
		case 4 : supprimerEquipe();break;
		case 5 : menuProfesseur();break;
		}


		menuGestionEquipes();
	}

	public static void supprimerEquipe() {
		int id =saisieInt("saisir l'id de l'équipe");
		daoEquipe.delete(id);

	}
	public static void modifierEquipe() {
		int id =saisieInt("saisir l'id de l'équipe");
		String libelle= saisieString("saisir le nom de l'équipe");
		int idMaison = saisieInt("saisir le n° de maison");
		Maison maison = daoMaison.findById(idMaison); 

		Equipe equipe = new Equipe(id,libelle,maison);

		daoEquipe.update(equipe);

	}
	public static void ajouterEquipe() {

		String libelle= saisieString("saisir le nom de l'équipe");
		int idMaison = saisieInt("saisir le n° de maison");
		Maison maison = daoMaison.findById(idMaison); 

		Equipe equipe = new Equipe(libelle,maison);
		daoEquipe.insert(equipe);
	}

	public static void afficherEquipes() {

		List<Equipe>equipe=daoEquipe.findAll();

		if (equipe.isEmpty()) {
			System.out.println("liste vide");
		} else {
			for (Equipe e : equipe) {
				System.out.println(e);
			}	
		}
	}	
	public static void menuGestionMaisons() {
		System.out.println("Menu Gestion des Maisons");
		System.out.println("1 - Afficher toutes les maisons");
		System.out.println("2 - Afficher maison par ID");
		System.out.println("3 - Insérer une maison");
		System.out.println("4 - Modifier une maison");
		System.out.println("5 - Supprimer une maison");
		System.out.println("6 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherMaisons();break;
		case 2 : afficherMaisonId();break;
		case 3 : ajouterMaison();break;
		case 4 : modifierMaison();break;
		case 5 : supprimerMaison();break;
		case 6 : menuProfesseur();break;
		}

		menuGestionMaisons();
	}


	public static void afficherMaisons() {
		List<Maison> maisons = daoMaison.findAll();

		if(maisons.isEmpty()) 
		{
			System.out.println("Aucune maison dans la base");
		}
		for(Maison m : maisons) 
		{
			System.out.println(m);
		}
	}

	public static void afficherMaisonId() {

		Integer id = saisieInt("Saisir l'id d'une maison");
		Maison maison = daoMaison.findById(id);

		if(maison==null) 
		{
			System.out.println("Cette maison n'existe pas en base");
		}
		else 
		{
			System.out.println(maison);
		}

	}

	public static void ajouterMaison() {
		String nom = saisieString("Saisir nom de la maison");
		int points = saisieInt("Saisir points de la maison");

		afficherProfesseurs();

		int id = saisieInt("Saisir ID du professeur");
		Professeur prof = (Professeur) daoSorcier.findById(id);
		Maison maison = new Maison(nom, points, prof);

		daoMaison.insert(maison);

	}

	public static void modifierMaison() {

		afficherMaisons();
		Integer idMaison = saisieInt("Saisir l'ID de la maison à modifier");
		if(daoMaison.findById(idMaison) != null) {
			String nom = saisieString("Saisir nom de la maison");
			int points = saisieInt("Saisir points de la maison");
			afficherProfesseurs();
			int idProf = saisieInt("Saisir ID du professeur");
			Professeur prof = (Professeur) daoSorcier.findById(idProf);
			Maison maison = new Maison(idMaison, nom, points, prof);

			daoMaison.update(maison);
		}
		else {
			System.out.println("La maison n'existe pas");
		}
	}


	public static void supprimerMaison() {
		afficherMaisons();
		Integer id = saisieInt("Choisir la maison");
		daoMaison.delete(id);

	}


	public static void menuGestionSorciers() {
		System.out.println("Menu Gestion des Sorciers");
		System.out.println("1- Afficher tous les sorciers");
		System.out.println("2- Ajouter un sorcier");
		System.out.println("3- Modifier un sorcier");
		System.out.println("4- Supprimer un sorcier");
		System.out.println("5 - Retour");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherSorciers();break;
		case 2 : ajouterSorcier();break;
		case 3 : modifierSorcier();break;
		case 4 : supprimerSorcier();break;
		case 5 : menuProfesseur();break;
		}

		menuGestionSorciers();
	}

	public static void supprimerSorcier() {
		afficherSorciers();
		Integer id = saisieInt("Saisir l'id du sorcier à supprimer");
		daoSorcier.delete(id);

	}
	public static void modifierSorcier() {
		String choix = saisieString("Modifier un Eleve ou un Professeur ?");
		Sorcier sorcier;
		if(choix.equals("Eleve")) 
		{
			afficherEleves();
			Integer id = saisieInt("Saisir l'id");
			String login=saisieString("Saisir login");
			String password = saisieString("Saisir password");
			String prenom=saisieString("Saisir prenom");
			String nom = saisieString("Saisir nom");

			int promotion = saisieInt("Saisir promotion");
			String nomAnimal = saisieString("Saisir le nom du familier");
			String raceAnimal = saisieString("Saisir la race du familier");
			Animal animal = new Animal(nomAnimal,raceAnimal);
			choix=saisieString("Affecter une maison ? y/n");
			Maison maison = null;
			if(choix.equals("y")) 
			{
				afficherMaisons();
				Integer idMaison = saisieInt("Saisir l'id");
				maison = daoMaison.findById(idMaison);
			}
			sorcier  = new Eleve(id,login,password,nom,prenom,promotion,animal,maison);

		}
		else 
		{
			afficherProfesseurs();
			Integer id = saisieInt("Saisir l'id");
			String login=saisieString("Saisir login");
			String password = saisieString("Saisir password");
			String prenom=saisieString("Saisir prenom");
			String nom = saisieString("Saisir nom");
			sorcier  = new Professeur(id,login,password,nom,prenom);
		}

		daoSorcier.update(sorcier);
	}


	public static void ajouterSorcier() {
		String choix = saisieString("Ajouter un Eleve ou un Professeur ?");
		Sorcier sorcier;
		if(choix.equals("Eleve")) 
		{
			String login=saisieString("Saisir login");
			String password = saisieString("Saisir password");
			String prenom=saisieString("Saisir prenom");
			String nom = saisieString("Saisir nom");

			int promotion = saisieInt("Saisir promotion");
			String nomAnimal = saisieString("Saisir le nom du familier");
			String raceAnimal = saisieString("Saisir la race du familier");
			Animal animal = new Animal(nomAnimal,raceAnimal);
			sorcier  = new Eleve(login,password,nom,prenom,promotion,animal,null);

		}
		else 
		{
			String login=saisieString("Saisir login");
			String password = saisieString("Saisir password");
			String prenom=saisieString("Saisir prenom");
			String nom = saisieString("Saisir nom");
			sorcier  = new Professeur(login,password,nom,prenom);
		}

		daoSorcier.insert(sorcier);

	}
	public static void afficherSorciers() {
		List<Sorcier> sorciers = 	daoSorcier.findAll();
		if(sorciers.isEmpty()) 
		{
			System.out.println("Aucun sorcier...");
		}
		else 
		{
			for(Sorcier s : sorciers) 
			{
				System.out.println(s);
			}
		}

	}
	public static void afficherProfesseurs() {

		List<Professeur> professeurs = 	daoSorcier.findAllProfesseurs();
		if(professeurs.isEmpty()) 
		{
			System.out.println("Aucun professeur...");
		}
		else 
		{
			for(Professeur p : professeurs) 
			{
				System.out.println(p);
			}
		}

	}
	public static void afficherEleves() {
		List<Eleve> eleves = 	daoSorcier.findAllEleves();
		if(eleves.isEmpty()) 
		{
			System.out.println("Aucun eleve...");
		}
		else 
		{
			for(Eleve e : eleves) 
			{
				System.out.println(e);
			}
		}

	}

	public static void menuPrincipal() {
		System.out.println("Menu principal des Sorciers :");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop");
		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 -> seConnecter();
		case 2 -> inscription();
		case 3 -> System.exit(0);
		}
		menuPrincipal();
	}



	public static void main(String[] args) {
		menuPrincipal();
	}
}
