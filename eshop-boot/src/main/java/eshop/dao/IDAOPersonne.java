package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;

public interface IDAOPersonne extends JpaRepository<Personne,Integer> {

	@Query("from Fournisseur")
	public List<Fournisseur> findAllFournisseur();
	@Query("from Client")
	public List<Client> findAllClient();
	
	@Query("from Client c left join fetch c.achats where c.id=:id")
	public Client findByIdWithAchats( @Param("id") Integer idClient);
	
	@Query("from Fournisseur f left join fetch f.stock where f.id=:id")
	public Fournisseur findByIdWithStock(@Param("id") Integer idFournisseur);
}
