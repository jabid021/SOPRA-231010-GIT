package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Arme;
import model.Boisson;
import model.Humain;
import model.Orc;
import model.Race;
import model.TypeArme;

public class Test {

	public static void main(String[] args) {
	
		Boisson boisson1 = new Boisson("Biere",8.50,true,150,"Ma 1ere boisson");
		
		Boisson boisson2 = new Boisson("Café",2.50,false,3,"Ma 2e boisson");
		
		
		Arme arme1 = new Arme("Sulfuras", TypeArme.Magique);
		Arme arme2 = new Arme("Arc legendaire des hunts",TypeArme.Distance);
		
		Race perso1 = new Orc("Jaxx",LocalDate.parse("2000-01-01"),arme1,150);
		Race perso2 = new Humain("Jdoe",LocalDate.now(),arme2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			//em.persist(boisson1);
			//em.persist(boisson2);
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
