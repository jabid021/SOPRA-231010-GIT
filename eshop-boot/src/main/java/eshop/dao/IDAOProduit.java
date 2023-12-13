package eshop.dao;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit,Integer> {

	@Query("from Produit p where p.libelle=:lib")
	public Produit findByLib(@Param("lib") String libelle);

	
	public Produit findByLibelle(String libelle);
	
	public List<Produit> findByPrixBetween(double min, double max);

	
	@Query("from Produit p left join fetch p.ventes where p.id=:id")
	public Produit findByIdWithVentes(@Param("id") Integer idProduit);
	
}
