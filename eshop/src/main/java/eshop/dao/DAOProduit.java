package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Produit;

@Repository
@Transactional
public class DAOProduit implements IDAOProduit{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit findById(Integer id) {
		return em.find(Produit.class, id);
	}

	@Override
	public List<Produit> findAll() {
		return em.createQuery("from Produit").getResultList();
	}

	@Override
	public Produit save(Produit produit) {
		return em.merge(produit);
	}


	@Override
	public void deleteById(Integer id) {
		em.remove(em.find(Produit.class, id));
	}

	@Override
	public void delete(Produit produit) {
	em.remove(em.merge(produit));
	}

	@Override
	public List<Produit> findByLib(String libelle) {
		return em.createQuery("from Produit p where p.libelle=:lib").setParameter("lib", libelle).getResultList();

	}

	@Override
	public Produit findByIdWithVentes(Integer idProduit) {
		// TODO Auto-generated method stub
		return null;
	}


}


