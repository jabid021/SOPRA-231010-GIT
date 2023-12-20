package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@RestController
@RequestMapping("/api/matiere")
@CrossOrigin("*")
public class MatiereRestController {

	@Autowired
	private IDAOMatiere daoMatiere;

	@GetMapping("")
	public List<Matiere> findAll() {
		return daoMatiere.findAll();
	}
	
	@GetMapping("/by-filiere/{idFiliere}")
	public List<Matiere> findAllByFiliere(@PathVariable Integer idFiliere) {
		return daoMatiere.findAllByFiliere(idFiliere);
	}
	
	
	@GetMapping("/{id}")
	public Matiere affiche(@PathVariable Integer id) 
	{
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


	@PutMapping("/{id}")
	public Matiere updateMatiere(@RequestBody Matiere matiere, @PathVariable Integer id)
	{
		if(id != matiere.getId() || !daoMatiere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		daoMatiere.save(matiere);
		
		return matiere;
	}

	@PatchMapping
	public void updatePartMatiere()
	{
		System.out.println("On est en patch");
	}

	@DeleteMapping("/{id}")
	public void deleteMatiere(@PathVariable Integer id)
	{
		daoMatiere.deleteById(id);
	}
}
