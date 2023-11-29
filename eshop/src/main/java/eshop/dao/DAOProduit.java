package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.context.Singleton;
import eshop.model.Produit;

public class DAOProduit implements IDAOProduit{


	@Override
	public Produit findById(Integer id) {
		Produit produit;

		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		produit = em.find(Produit.class, id);
		em.close();
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		produits = em.createQuery("from Produit").getResultList();
		em.close();
		return produits;
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		produit = em.merge(produit);
		em.getTransaction().commit();
		em.close();
		return produit;
	}


	@Override
	public void deleteById(Integer id) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Produit produit = em.find(Produit.class, id);
		em.remove(produit);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Produit produit) {
		EntityManager em= Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		produit = em.merge(produit);
		em.remove(produit);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Produit> findByLib(String libelle) {
		List<Produit> produits;

		EntityManager em =  Singleton.getInstance().getEmf().createEntityManager();
		produits = em.createQuery("from Produit p where p.libelle=:lib").setParameter("lib",libelle).getResultList();
		em.close();
		return produits;
	}
	
	@Override
	public Produit findByIdWithVentes(Integer idProduit) {
		// TODO Auto-generated method stub
		return null;
	}



}


