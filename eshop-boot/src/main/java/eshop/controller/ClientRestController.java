package eshop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.controller.dto.AchatResponse;
import eshop.controller.dto.ClientResponse;
import eshop.dao.IDAOPersonne;
import eshop.model.Achat;
import eshop.model.Client;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private IDAOPersonne daoPersonne;
	
	@GetMapping("{id}/facture")
	public ClientResponse facture(@PathVariable Integer id) 
	{
		Client client = daoPersonne.findByIdWithAchats(id);
		ClientResponse c = new ClientResponse();
		BeanUtils.copyProperties(client, c);
		c.setNumero(client.getAdresse().getNumero());
		c.setVoie(client.getAdresse().getVoie());
		c.setVille(client.getAdresse().getVille());
		c.setCp(client.getAdresse().getCp());
		
		AchatResponse a;
		for(Achat achat : client.getAchats()) 
		{
			a=new AchatResponse();
			BeanUtils.copyProperties(achat, a);
			a.setLibelle(achat.getProduit().getLibelle());
			a.setPrix(achat.getProduit().getPrix());
			a.setDate(achat.getDateAchat().toString());
			a.calculTotal();
			c.getAchats().add(a);
		}
		
		return c;
	}
}
