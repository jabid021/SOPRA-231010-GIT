package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Achat;

public class DAOAchat implements IDAOAchat{


	@Override
	public Achat findById(Integer id) {
		Achat achat;

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		achat = em.find(Achat.class, id);
		em.close();
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		List<Achat> achats;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		achats = em.createQuery("from Achat").getResultList();
		em.close();
		return achats;
	}

	@Override
	public Achat save(Achat achat) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		achat = em.merge(achat);
		em.getTransaction().commit();
		em.close();
		return achat;
	}


	@Override
	public void deleteById(Integer id) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Achat achat = em.find(Achat.class, id);
		em.remove(achat);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Achat achat) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		achat = em.merge(achat);
		em.remove(achat);
		em.getTransaction().commit();
		em.close();
	}



}


