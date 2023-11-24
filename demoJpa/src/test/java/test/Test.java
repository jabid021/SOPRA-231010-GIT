package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Boisson;

public class Test {

	public static void main(String[] args) {
	
		Boisson boisson1 = new Boisson("Biere",8.50,true,150);
		
		Boisson boisson2 = new Boisson("Café",2.50,false,3);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			em.persist(boisson1);
			em.persist(boisson2);
		
		em.getTransaction().commit();
		
		em.close();
		
		
	
		
	/*	em = emf.createEntityManager();
		
			System.out.println(em.find(Boisson.class, 1));
		
		em.close();
	*/	
	
		
		emf.close();
	}

}
