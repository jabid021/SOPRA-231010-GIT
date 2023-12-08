package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOMatiere;
import quest.dao.IDAOStagiaire;
import quest.model.Matiere;
import quest.model.Stagiaire;

@RestController
@RequestMapping("/api/matiere")
public class MatiereRestController {

	@Autowired
	private IDAOMatiere daoMatiere;
	@Autowired
	private IDAOStagiaire daoStagiaire;
	
	
	@GetMapping("/{id}")
	public Matiere affiche(@PathVariable Integer id,@RequestParam String texte) 
	{
		System.out.println("Texte recu en param : "+texte);
		return daoMatiere.findById(id).get();
	}
	
	@GetMapping("/new")
	public Matiere newMatiere() 
	{
		return new Matiere(1,"Libelle matiere",7889);
	}
}
