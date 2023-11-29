package quest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import quest.context.Singleton;
import quest.model.Matiere;

public class DAOMatiere implements IDAOMatiere{

	
	@Override
	public Matiere findById(Integer id) {
		Matiere matiere = null;

		EntityManager em = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
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
		List<Matiere> matieres  = new ArrayList();

		EntityManager em = null;

		try {
			em =  Singleton.getInstance().getEmf().createEntityManager();
			matieres = em.createQuery("from Matiere").getResultList();
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

		return matieres;
	}

	@Override
	public Matiere save(Matiere matiere) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try 
		{
			em= Singleton.getInstance().getEmf().createEntityManager();
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
	public void deleteById(Integer id) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try 
		{
			em= Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Matiere matiere = em.find(Matiere.class, id);
			em.remove(matiere);
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
	}

	@Override
	public void delete(Matiere matiere) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try 
		{
			em= Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			matiere = em.merge(matiere);
			em.remove(matiere);
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
	}
}


