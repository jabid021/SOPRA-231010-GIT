package quest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOMatiere;
import quest.dao.IDAOStagiaire;
import quest.model.Matiere;

@RestController
@RequestMapping("/api/matiere")
@CrossOrigin("*")
public class MatiereRestController {

	@Autowired
	private IDAOMatiere daoMatiere;


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

	@PostMapping
	public Matiere insertMatiere(@RequestBody Matiere matiere)
	{
		daoMatiere.save(matiere);
		return matiere;
	}


	@PutMapping
	public Matiere updateMatiere(@RequestBody Matiere matiere)
	{
		daoMatiere.save(matiere);
		return matiere;
	}

	@PatchMapping
	public void updatePartMatiere()
	{
		System.out.println("On est en patch");
	}

	@DeleteMapping
	public void deleteMatiere()
	{
		System.out.println("On est en delete");
	}
}
