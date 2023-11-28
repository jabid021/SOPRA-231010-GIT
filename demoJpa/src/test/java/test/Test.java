package test;

import java.time.LocalDate;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Arme;
import model.Boisson;
import model.Humain;
import model.Item;
import model.Monture;
import model.Orc;
import model.Personnage;
import model.TypeArme;
import model.heritage.joined.Eleve;
import model.heritage.joined.Professeur;
import model.heritage.perClass.Chat;
import model.heritage.perClass.Chien;
import model.heritage.superClass.Bateau;
import model.heritage.superClass.Voiture;

public class Test {

	public static void main(String[] args) {
	
		Boisson boisson1 = new Boisson("Biere",8.50,true,150,"Ma 1ere boisson");
		
		Boisson boisson2 = new Boisson("Café",2.50,false,3,"Ma 2e boisson");
		
		
		Arme arme1 = new Arme("Sulfuras", TypeArme.Magique);
		Arme arme2 = new Arme("Arc legendaire des hunts",TypeArme.Distance);
		
		Monture monture1 = new Monture("Galopa",300);
		
		Item objet1 = new Item("Potion");
		Item objet2 = new Item("Corde de sortie");
		Item objet3 = new Item("Pokeball");
		Item objet4 = new Item("Pokedex");
		Item objet5 = new Item("Rappel");
		
		Personnage perso1 = new Orc("Jaxx",LocalDate.parse("2000-01-01"),arme1,150,monture1,boisson1);
		

		
		Personnage perso2 = new Humain("Jdoe",LocalDate.now(),arme2,null,boisson2);
		
		Collections.addAll(perso1.getInventaire(), objet1,objet1,objet1,objet3,objet4);
		Collections.addAll(perso2.getInventaire(), objet1,objet3,objet3,objet4);
		
		
		Collections.addAll(objet1.getPossesseurs(), perso1,perso1,perso1,perso2);
		Collections.addAll(objet3.getPossesseurs(), perso1,perso2,perso2);
		Collections.addAll(objet4.getPossesseurs(), perso1,perso2);
		
		//boisson1.getAmateurs().add(perso1);
		//boisson1.getAmateurs().add(perso2);
		
		
		
		
	/*	Eleve eleve = new Eleve("Potter","Harry",7);
		Professeur prof = new Professeur("Rogue","Severus","Salle 7B");
		
		Chat chat = new Chat("gris",7);
		
		Chien chien = new Chien("blanc",60);
		
		
		Bateau bateau = new Bateau(80,"Neuves");
		Voiture voiture = new Voiture(250,"Ferrari");
		
	*/	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
		EntityManager em = emf.createEntityManager();
		
		
		/*em.getTransaction().begin();
		em.persist(bateau);
		em.persist(voiture);
		//em.persist(chat);
		//em.persist(chien);
		//em.persist(eleve);
		//em.persist(prof);*/
		
		
		
			em.persist(objet1);
			em.persist(objet2);
			em.persist(objet3);
			em.persist(objet4);
			em.persist(objet5);
			em.persist(monture1);
			em.persist(boisson1);
			em.persist(boisson2);
			em.persist(perso1);
			em.persist(perso2);
			
			
		em.getTransaction().commit();
		
		em.close();
		
		
	
		
	/*	em = emf.createEntityManager();
		
			System.out.println(em.find(Boisson.class, 1));
		
		em.close();
	*/	
	
		
		emf.close();
	}

}
