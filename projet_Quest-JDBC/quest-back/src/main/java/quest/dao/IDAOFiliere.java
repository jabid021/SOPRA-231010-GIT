package quest.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer>{
	
	public List<Filiere> findByDebutBetween(LocalDate debutInterval, LocalDate finInterval);

	@Query("from Filiere f where f.debut between :debut and :fin")
	public List<Filiere> filiereDebutEntreInterval(@Param("debut") LocalDate debutInterval, @Param("fin") LocalDate finInterval);
	
	@Query("SELECT f from Filiere f left join fetch f.eleves where f.id=:id ")
	public Filiere findByIdWithEleves(@Param("id") Integer id);
}
