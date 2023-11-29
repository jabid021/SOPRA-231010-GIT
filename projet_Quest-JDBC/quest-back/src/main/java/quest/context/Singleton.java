package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOStagiaire;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;

public class Singleton {

	
	private static Singleton instance=null;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA"); 
	
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOStagiaire daoStagiare = new DAOStagiaire();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	
	
	
	
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


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}


	public void setDaoMatiere(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}


	public IDAOStagiaire getDaoStagiare() {
		return daoStagiare;
	}


	public void setDaoStagiare(IDAOStagiaire daoStagiare) {
		this.daoStagiare = daoStagiare;
	}


	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}


	public void setDaoFiliere(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}


	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}


	public void setDaoOrdinateur(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}


	
	
	
}
