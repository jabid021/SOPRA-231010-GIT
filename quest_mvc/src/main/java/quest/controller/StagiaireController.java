package quest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@Controller
@RequestMapping("/stagiaire") // Debute l'url de toutes les fonctions par "/stagiaire..."
public class StagiaireController {
	
	@Autowired
	private IDAOStagiaire daoStagiaire;
	@Autowired
	private IDAOFiliere daoFiliere;
	
	
	@GetMapping
	public String allStagiaires(Model model) 
	{
		List<Stagiaire> stagiairesBdd = daoStagiaire.findAll();
		model.addAttribute("stagiaires",stagiairesBdd);
		model.addAttribute("filieres",daoFiliere.findAll());
		model.addAttribute("stagiaire",new Stagiaire());
		return "stagiaires/stagiaires";
		
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerStagiaire(@PathVariable Integer id) 
	{
		daoStagiaire.deleteById(id);
		
		return "redirect:/stagiaire";
	}
	
	@GetMapping("/{id}")
	public String ficheStagiaire(@PathVariable Integer id,Model model) 
	{
		Stagiaire stagiaireBdd = daoStagiaire.findById(id).get();
		model.addAttribute("stagiaire",stagiaireBdd);
		model.addAttribute("filieres",daoFiliere.findAll());
		return "stagiaires/updateStagiaire";
	}
	
	@PostMapping

	public String saveStagiaire(@Valid @ModelAttribute Stagiaire stagiaire,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("filieres",daoFiliere.findAll());
			if(stagiaire.getId()==null) 
			{
				model.addAttribute("stagiaires",daoStagiaire.findAll());
				return "stagiaires/stagiaires";
			}
			return "stagiaires/updateStagiaire";
		}
		daoStagiaire.save(stagiaire);
		
		return "redirect:/stagiaire";
	}
	
	
	
	

}
