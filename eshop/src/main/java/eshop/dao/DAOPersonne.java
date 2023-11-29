package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

public class DAOPersonne implements IDAOPersonne{


	@Override
	public Personne findById(Integer id) {
		Personne personne;

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		personne = em.find(Personne.class, id);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		personnes = em.createQuery("from Personne").getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		personne = em.merge(personne);
		em.getTransaction().commit();
		em.close();
		return personne;
	}


	@Override
	public void deleteById(Integer id) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Personne personne = em.find(Personne.class, id);
		em.remove(personne);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Personne personne) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		personne = em.merge(personne);
		em.remove(personne);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		List<Fournisseur> fournisseurs;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		fournisseurs = em.createQuery("from Fournisseur").getResultList();
		em.close();
		return fournisseurs;
	}

	@Override
	public List<Client> findAllClient() {
		List<Client> clients;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		clients = em.createQuery("from Client").getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur findByIdWithStock(Integer idFournisseur) {
		// TODO Auto-generated method stub
		return null;
	}



}


