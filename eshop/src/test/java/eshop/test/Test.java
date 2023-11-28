package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Achat;
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
		
		Achat a1 = new Achat(LocalDate.now(), 1, client1,produit1);
		Achat a2 = new Achat(LocalDate.now(), 1, client1,produit2);
		Achat a3 = new Achat(LocalDate.now(), 2, client1,produit3);
		
		/*client1.getAchats().add(a1);
		client1.getAchats().add(a2);
		client1.getAchats().add(a3);
		*/
		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(client1);
		em.persist(fournisseur1);
		em.persist(produit1);
		em.persist(produit2);
		em.persist(produit3);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		em.getTransaction().commit();

		em.close();

		emf.close();
	}

}
