package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Ordinateur;

@Repository
@Transactional
public class DAOOrdinateur implements IDAOOrdinateur{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ordinateur findById(Integer id) {
		return em.find(Ordinateur.class, id);
	}

	@Override
	public List<Ordinateur> findAll() {
		return em.createQuery("from Ordinateur").getResultList();
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		return em.merge(ordinateur);
	}


	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(Ordinateur.class, id));
	}

	@Override
	public void delete(Ordinateur ordinateur) {
	em.remove(em.merge(ordinateur));
	}


}


