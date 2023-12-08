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

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;
import quest.view.Views;

@RestController
@RequestMapping("/api/stagiaire")
public class StagiaireRestController {

	@Autowired
	private IDAOStagiaire daoStagiaire;
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Stagiaire.class)
	public Stagiaire findById(@PathVariable Integer id) 
	{
		Optional<Stagiaire> opt = daoStagiaire.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Stagiaire> findAll() 
	{
		return daoStagiaire.findAll();
	}
	
	@GetMapping("/all")
	@JsonView(Views.Stagiaire.class)
	public List<Stagiaire> findAllWithOrdinateurAndFiliere() 
	{
		return daoStagiaire.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Stagiaire.class)
	public Stagiaire insert(@RequestBody Stagiaire stagiaire) 
	{
		return daoStagiaire.save(stagiaire);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Stagiaire.class)
	public Stagiaire update(@RequestBody Stagiaire stagiaire) 
	{
	
		return daoStagiaire.save(stagiaire);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoStagiaire.deleteById(id);
	}
	
}
