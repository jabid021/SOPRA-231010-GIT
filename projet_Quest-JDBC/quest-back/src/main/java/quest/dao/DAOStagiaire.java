package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Stagiaire;

@Repository
@Transactional
public class DAOStagiaire implements IDAOStagiaire{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Stagiaire findById(Integer id) {
		return em.find(Stagiaire.class, id);
	}

	@Override
	public List<Stagiaire> findAll() {
		return em.createQuery("from Stagiaire").getResultList();
	}

	@Override
	public Stagiaire save(Stagiaire stagiaire) {
		return em.merge(stagiaire);
	}


	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(Stagiaire.class, id));
	}

	@Override
	public void delete(Stagiaire stagiaire) {
	em.remove(em.merge(stagiaire));
	}


}


