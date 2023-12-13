package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere,Integer> {
	@Query("select m from Filiere f join f.matieres m where f.id = :id")
	List<Matiere> findAllByFiliere(@Param("id") Integer id);
}
