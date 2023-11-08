package hopital.context;

import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.dao.jdbc.DAOCompteJDBC;
import hopital.dao.jdbc.DAOPatientJDBC;
import hopital.dao.jdbc.DAOVisiteJDBC;

public class Singleton {

	
	private IDAOCompte daoCompte = new DAOCompteJDBC();
	private IDAOVisite daoVisite = new DAOVisiteJDBC();
	private IDAOPatient daoPatient = new DAOPatientJDBC();

	
	private static Singleton instance=null;
	
	
	
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
	
	
	
	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}
	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}
	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}
	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}
	
	
	
	
	
	
	
	
}
