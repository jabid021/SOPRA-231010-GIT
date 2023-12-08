package quest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Controller
@RequestMapping("/api/matiereV0")
public class MatiereRestControllerV0 {

	@Autowired
	private IDAOMatiere daoMatiere;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Matiere affiche(@PathVariable Integer id,@RequestParam String texte) 
	{
		System.out.println("Texte recu en param : "+texte);
		return daoMatiere.findById(id).get();
	}
	
}
