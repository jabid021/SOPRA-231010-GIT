package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOMatiere;

public class DemoDAO {

	
	
	
	static DAOMatiere daoM = new DAOMatiere();
	public static void main(String[] args) {
	

		System.out.println(daoM.findAll());
		
		
	}

}
