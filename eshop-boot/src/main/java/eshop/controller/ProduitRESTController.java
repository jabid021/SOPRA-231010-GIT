package eshop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;
import eshop.view.Views;

@RestController
@RequestMapping("/api/produit")
public class ProduitRESTController {

	@Autowired
	private IDAOProduit daoProduit;
	
	
	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit findById(@PathVariable Integer id) 
	{
		Optional<Produit> opt = daoProduit.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Produit> findAll() 
	{
		return daoProduit.findAll();
	}
	
	@GetMapping("/ventes/{id}")
	@JsonView(Views.ProduitWithVentes.class)
	public Produit findByIdWithVentes(@PathVariable Integer id) 
	{
		return daoProduit.findByIdWithVentes(id);
	}
	
	
	@PostMapping
	@JsonView(Views.Produit.class)
	public Produit insert(@Valid @RequestBody Produit produit, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit n'est pas valide...");
		}
		return daoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit update(@Valid @RequestBody Produit produit, BindingResult result) 
	{
		if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit n'est pas valide...");
		}
		return daoProduit.save(produit);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoProduit.deleteById(id);
	}
	
}
