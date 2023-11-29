package quest.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Filiere;

public class DAOFiliere implements IDAOFiliere{


	@Override
	public Filiere findById(Integer id) {
		Filiere filiere;

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filiere = em.find(Filiere.class, id);
		em.close();
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		List<Filiere> filieres;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		filieres = em.createQuery("from Filiere").getResultList();
		em.close();
		return filieres;
	}

	@Override
	public Filiere save(Filiere filiere) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		filiere = em.merge(filiere);
		em.getTransaction().commit();
		em.close();
		return filiere;
	}


	@Override
	public void deleteById(Integer id) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Filiere filiere = em.find(Filiere.class, id);
		em.remove(filiere);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Filiere filiere) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		filiere = em.merge(filiere);
		em.remove(filiere);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Filiere> findByDebutBetween(LocalDate debutInterval, LocalDate finInterval) {
		List<Filiere> filieres;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		filieres = em.createQuery("from Filiere f where f.debut between :debut and :fin")
					.setParameter("debut",debutInterval)
					.setParameter("fin",finInterval)
					.getResultList();

		/*	Query query = em.createQuery("from Filiere f where f.debut between :debut and :fin");
			query.setParameter("debut",debutInterval);
			query.setParameter("fin",finInterval);
			filieres = query.getResultList();
		 */

		em.close();
		return filieres;
	}


}


