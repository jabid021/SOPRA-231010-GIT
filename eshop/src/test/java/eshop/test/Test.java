package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		Adresse adresse1 = new Adresse("6","rue rougement","75009","Paris");
		Adresse adresse2 = new Adresse("24","rue de paris","75001","Paris");

		Client client1 = new Client("Abid", "Jordan",adresse2,30,LocalDate.parse("1993-05-01"));

		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly",adresse1,"AJC");

		Produit produit1 = new Produit("Formation JPA",1600,fournisseur1);
		Produit produit2 = new Produit("Formation SQL",1000,fournisseur1);
		Produit produit3 = new Produit("Formation Angular",2200,fournisseur1);

		
		client1.getAchats().add(produit1);
		client1.getAchats().add(produit2);
		client1.getAchats().add(produit3);
		client1.getAchats().add(produit3);
		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(client1);
		em.persist(fournisseur1);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(produit3);
		
		
		em.getTransaction().commit();

		em.close();

		emf.close();
	}

}
