package quest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.view.Views;

@RestController
@RequestMapping("/api/filiere")
public class FiliereRestController {

	@Autowired
	private IDAOFiliere daoFiliere;
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Filiere.class)
	public Filiere findById(@PathVariable Integer id) 
	{
		Optional<Filiere> opt = daoFiliere.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Filiere> findAll() 
	{
		return daoFiliere.findAll();
	}
	
	@GetMapping("/stagiaires")
	@JsonView(Views.FiliereWithStagiaires.class)
	public List<Filiere> findAllWithStagiaires() 
	{
		return daoFiliere.findAllWithStagiaires();
	}
	
	@GetMapping("/matieres")
	@JsonView(Views.FiliereWithMatieres.class)
	public List<Filiere> findAllWithMatieres() 
	{
		return daoFiliere.findAllWithMatieres();
	}
	
	
	
	@PostMapping
	@JsonView(Views.Filiere.class)
	public Filiere insert(@RequestBody Filiere filiere) 
	{
		return daoFiliere.save(filiere);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Filiere.class)
	public Filiere update(@RequestBody Filiere filiere) 
	{
	
		return daoFiliere.save(filiere);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoFiliere.deleteById(id);
	}
	
}
