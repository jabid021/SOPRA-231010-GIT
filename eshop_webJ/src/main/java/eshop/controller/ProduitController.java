package eshop.controller;

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

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Produit;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private IDAOProduit daoProduit;
	
	@Autowired
	private IDAOPersonne daoPersonne;
	
	@GetMapping
	public String allProduits(Model model) 
	{
		model.addAttribute("produits",daoProduit.findAll());
		model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
		model.addAttribute("produit", new Produit());
		return "produits/produits";
	}
	
	
	@GetMapping("/{id}")
	public String ficheProduit(@PathVariable Integer id,Model model) 
	{
		model.addAttribute("produit",daoProduit.findById(id).get());
		model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
		return "produits/updateProduit";
	}
	
	@PostMapping
	public String ajoutProduit(@Valid @ModelAttribute Produit produit,BindingResult result,Model model) 
	{

		if(result.hasErrors()) 
		{
			model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
			model.addAttribute("produits",daoProduit.findAll());
			return "produits/produits";
		}
		daoProduit.save(produit);
		return "redirect:/produit";
	}
	
	@PostMapping("/{id}")
	public String modifierProduit(@Valid Produit produit,BindingResult result,Model model) 
	{
		if(result.hasErrors()) 
		{
			model.addAttribute("fournisseurs",daoPersonne.findAllFournisseur());
			return "produits/updateProduit";
		}
		daoProduit.save(produit);
		return "redirect:/produit";
	}
	
	
	@GetMapping("/delete/{id}")
	public String supprimerProduit(@PathVariable Integer id) 
	{
		daoProduit.deleteById(id);
		return "redirect:/produit";
	}
}
