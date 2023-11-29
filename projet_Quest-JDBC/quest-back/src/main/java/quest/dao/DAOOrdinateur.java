package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur{


	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur ordinateur;

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
			ordinateur = em.find(Ordinateur.class, id);
		em.close();
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
			ordinateurs = em.createQuery("from Ordinateur").getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
			ordinateur = em.merge(ordinateur);
		em.getTransaction().commit();
		em.close();
		return ordinateur;
	}

	
	@Override
	public void deleteById(Integer id) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			Ordinateur ordinateur = em.find(Ordinateur.class, id);
			em.remove(ordinateur);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Ordinateur ordinateur) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
			ordinateur = em.merge(ordinateur);
			em.remove(ordinateur);
		em.getTransaction().commit();
		em.close();
	}


}


