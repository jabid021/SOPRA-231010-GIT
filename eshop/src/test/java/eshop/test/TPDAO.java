package eshop.test;

import eshop.context.Singleton;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;

public class TPDAO {

	static IDAOProduit daoProduit = Singleton.getInstance().getDaoProduit();
	static IDAOPersonne daoPersonne = Singleton.getInstance().getDaoPersonne();
	static IDAOAchat daoAchat = Singleton.getInstance().getDaoAchat();
	
	
	public static void main(String[] args) {	
		System.out.println(daoProduit.findAll());
		
		System.out.println("-------------");
		
		System.out.println(daoProduit.findByLib("Formation SQL"));
		
		System.out.println("-------------------");
		
		System.out.println(daoPersonne.findAllClient());
		
		System.out.println("-------------------");
		
		System.out.println(daoPersonne.findAllFournisseur());
	}
}
