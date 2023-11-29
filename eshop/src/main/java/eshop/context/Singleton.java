package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOAchat;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;

public class Singleton {

	
	private static Singleton instance=null;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA"); 
	
	private IDAOProduit daoProduit = new DAOProduit();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	private IDAOAchat daoAchat = new DAOAchat();
	
	
	
	
	private Singleton() {}


	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance = new Singleton();
		}
		return instance;
	}


	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}


	public void setDaoProduit(IDAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}


	public void setDaoPersonne(IDAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}


	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}


	public void setDaoAchat(IDAOAchat daoAchat) {
		this.daoAchat = daoAchat;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	

	
	
	
}
