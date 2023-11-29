package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Filiere;

public class DAOFiliere implements IDAOFiliere {

	@Override
	public Filiere findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Filiere> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filiere save(Filiere filiere) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		filiere = em.merge(filiere);
		em.getTransaction().commit();
		return filiere;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Filiere> findByDebutBetween(LocalDate debut, LocalDate fin) {
		// TODO Auto-generated method stub
		return null;
	}

}
