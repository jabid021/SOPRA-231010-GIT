package quest.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import quest.controller.dto.FiliereRequest;
import quest.controller.dto.FiliereResponse;
import quest.controller.dto.StagiaireResponse;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Stagiaire;
import quest.view.Views;

@RestController
@RequestMapping("/api/filiere")
public class FiliereRestController {

	@Autowired
	private IDAOFiliere daoFiliere;
	
	@Autowired
	private IDAOStagiaire daoStagiaire;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@GetMapping("/{id}/dto")
	public FiliereResponse findByIdDTO(@PathVariable Integer id) 
	{
		Optional<Filiere> opt = daoFiliere.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		
		Filiere filiere = opt.get();
		
		FiliereResponse filiereDTO = new FiliereResponse();
		
		BeanUtils.copyProperties(filiere, filiereDTO);
		filiereDTO.setTitre(filiere.getLibelle());
		filiereDTO.setDebut(filiere.getDebut().toString());
		filiereDTO.setFin(filiere.getFin().toString());
		
		for(Matiere matiere : filiere.getMatieres()) {
			filiereDTO.addMatiere(matiere.getLibelle());
		}
		
		for(Stagiaire stagiaire: filiere.getEleves()) {
			StagiaireResponse stagiaireResponse = new StagiaireResponse();
			BeanUtils.copyProperties(stagiaire, stagiaireResponse);
			
			filiereDTO.addStagiaire(stagiaireResponse);
		}
		
		return filiereDTO;
	}
	
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
	
	@GetMapping("/{id}/with-stagiaires")
	@JsonView(Views.FiliereWithStagiaires.class)
	public Filiere findByIdWithStagiaires(@PathVariable Integer id) 
	{
		Filiere filiere = daoFiliere.findByIdWithEleves(id);
		
		return filiere;
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
	
	
	@PostMapping("/with-eleves")
	@Transactional
	public Filiere insertWithEleves(@RequestBody FiliereRequest filiereRequest) 
	{
		Filiere filiere = new Filiere();
		
		BeanUtils.copyProperties(filiereRequest, filiere);
		
		filiere = daoFiliere.save(filiere);
		
		for(String email : filiereRequest.getEleves()) {
			Stagiaire stagiaire = daoStagiaire.findByEmail(email);
			stagiaire.setFiliere(filiere);
			
			stagiaire = daoStagiaire.save(stagiaire);
		}
		
		em.refresh(filiere);
		
		return filiere;
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
