package quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Controller
@RequestMapping("/matiere") // Debute l'url de toutes les fonctions par "/matiere..."
public class MatiereController {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	
	@GetMapping
	public String allMatieres(Model model) 
	{
		List<Matiere> matieresBdd = daoMatiere.findAll();
		
		model.addAttribute("matieres",matieresBdd);
		return "/WEB-INF/matieres.jsp";
		
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerMatiere(@PathVariable Integer id) 
	{
		daoMatiere.deleteById(id);
		
		return "redirect:/matiere";
	}
	
	@GetMapping("/{id}")
	public String ficheMatiere(@PathVariable Integer id,Model model) 
	{
		Matiere matiereBdd = daoMatiere.findById(id).get();
		model.addAttribute("matiere",matiereBdd);
		return "/WEB-INF/updateMatiere.jsp";
	}
	
	@PostMapping
	public String ajoutMatiere(String libelle, Integer quest) 
	{
		Matiere matiere = new Matiere(libelle,quest);
		daoMatiere.save(matiere);
		
		return "redirect:/matiere";
	}
	
	@PostMapping("/{id}")
	public String modifierMatiere(@PathVariable Integer id, String libelle, Integer quest) 
	{
		Matiere matiere = new Matiere(id,libelle,quest);
		daoMatiere.save(matiere);
		return "redirect:/matiere";
	}
	
	
	
	

}
