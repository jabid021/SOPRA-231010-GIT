package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestSpringJPA {

	@Autowired
	private IDAOProduit daoProduit;
	
	@Autowired
	private IDAOPersonne daoPersonne;
	
	@Autowired
	private IDAOAchat daoAchat;
	
	public void initBdd() 
	{
		Adresse adresse1 = new Adresse("6","rue rougement","75009","Paris");
		Adresse adresse2 = new Adresse("24","rue de paris","75001","Paris");

		Client client1 = new Client("Abid", "Jordan",adresse2,30,LocalDate.parse("1993-05-01"));
		
		client1 = (Client) daoPersonne.save(client1);
		

		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly",adresse1,"AJC");

		fournisseur1 = (Fournisseur) daoPersonne.save(fournisseur1);
		
		Produit produit1 = new Produit("Formation JPA",1600,fournisseur1);
		Produit produit2 = new Produit("Formation SQL",1000,fournisseur1);
		Produit produit3 = new Produit("Formation Angular",2200,fournisseur1);
		
		produit1 = daoProduit.save(produit1);
		produit2 = daoProduit.save(produit2);
		produit3 = daoProduit.save(produit3);
		
		Achat a1 = new Achat(LocalDate.now(), 1, client1,produit1);
		Achat a2 = new Achat(LocalDate.now(), 1, client1,produit2);
		Achat a3 = new Achat(LocalDate.now(), 2, client1,produit3);
		
		daoAchat.save(a1);
		daoAchat.save(a2);
		daoAchat.save(a3);
	}
	
	
	public void run(String[] ...args) 
	{
		//initBdd();
		
		for(Produit p : daoProduit.findAll()) {
		System.out.println(p);
		}
		
		System.out.println(daoProduit.findByLib("Formation SQL"));
		
	}
}
