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

		Produit produit = new Produit("Formation JPA",1600);

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(client1);
		em.persist(produit);
		em.persist(fournisseur1);
		
		em.getTransaction().commit();

		em.close();

		emf.close();
	}

}
