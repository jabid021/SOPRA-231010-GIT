package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Matiere;

public class DAOMatiere implements IDAOMatiere{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
	
	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = null;
		
		EntityManager em = null;
		
		try {
			em = emf.createEntityManager();
			matiere = em.find(Matiere.class, id);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere save(Matiere matiere) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try 
		{
			em=emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
				matiere = em.merge(matiere);
			tx.commit();
		}
		catch(Exception e) 
		{
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		
		return matiere;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
