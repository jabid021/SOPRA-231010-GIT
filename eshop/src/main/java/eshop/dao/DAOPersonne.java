package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findById(Integer id) {
		return em.find(Personne.class, id);
	}

	@Override
	public List<Personne> findAll() {
		return em.createQuery("from Personne").getResultList();
	}

	@Override
	public Personne save(Personne personne) {
		return em.merge(personne);
	}


	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(Personne.class, id));
	}

	@Override
	public void delete(Personne personne) {
	em.remove(em.merge(personne));
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		return em.createQuery("from Fournisseur").getResultList();
	}

	@Override
	public List<Client> findAllClient() {
		return em.createQuery("from Client").getResultList();
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		return (Client) em.createQuery("from Client c left join fetch c.achats where c.id=:id").setParameter("id", idClient).getSingleResult();
	}

	@Override
	public Fournisseur findByIdWithStock(Integer idFournisseur) {
		// TODO Auto-generated method stub
		return null;
	}


}


