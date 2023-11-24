package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
	Personne personne = new Personne("Langlade", "Pierre");
	Produit produit = new Produit("Canard",9.99);

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			em.persist(personne);
			em.persist(produit);
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
	}

}
