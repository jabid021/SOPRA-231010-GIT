package eshop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eshop.model.Produit;

@RestController
//@Controller => @ResponseBody sur toutes les fonctions qui return de la data
@RequestMapping("/api/demo")
@CrossOrigin("*")
public class DemoRESTController {

	@GetMapping("/{nb}")
	public String demo(@PathVariable(name="nb") Integer id,@RequestParam(name="login") String log)
	{
		return "Requête avec les valeurs "+id+" et "+log;
	}

	@GetMapping
	public Produit produit() 
	{
		return new Produit();
	}
	
	
}
