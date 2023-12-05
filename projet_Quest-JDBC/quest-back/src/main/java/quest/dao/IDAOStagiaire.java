package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.model.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire,Integer> {

}
