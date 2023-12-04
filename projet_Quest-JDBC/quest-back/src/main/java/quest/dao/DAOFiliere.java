package quest.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import quest.model.Filiere;

@Repository
@Transactional
public class DAOFiliere implements IDAOFiliere{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Filiere findById(Integer id) {
		return em.find(Filiere.class, id);
	}

	@Override
	public List<Filiere> findAll() {
		return em.createQuery("from Filiere").getResultList();
	}

	@Override
	public Filiere save(Filiere filiere) {
		return em.merge(filiere);
	}


	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(Filiere.class, id));
	}

	@Override
	public void delete(Filiere filiere) {
	em.remove(em.merge(filiere));
	}

	@Override
	public List<Filiere> findByDebutBetween(LocalDate debutInterval, LocalDate finInterval) {
		return em.createQuery("from Filiere f where f.debut between :deb and :fin").setParameter("deb",debutInterval).setParameter("fin",finInterval).getResultList();
	}

	@Override
	public Filiere findByIdWithEleves(Integer id) {
		return (Filiere) em.createQuery("from Filiere f left join fetch f.eleves e where f.id=:id").setParameter("id", id).getSingleResult();
	}


}


