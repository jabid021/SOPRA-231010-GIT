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
	public ClientResponse facture(@PathVariable Integer id) {
		Client client = daoPersonne.findByIdWithAchats(id);
		ClientResponse clientResp = new ClientResponse();
		BeanUtils.copyProperties(client, clientResp);
		BeanUtils.copyProperties(client.getAdresse(), clientResp);
//		clientResp.setNumero(client.getAdresse().getNumero());
//		clientResp.setVoie(client.getAdresse().getVoie());
//		clientResp.setVille(client.getAdresse().getVille());
//		clientResp.setCp(client.getAdresse().getCp());

		for (Achat achat : client.getAchats()) {
			AchatResponse achatResp = new AchatResponse();
			BeanUtils.copyProperties(achat, achatResp);
			BeanUtils.copyProperties(achat.getProduit(), achatResp);
//			achatResp.setLibelle(achat.getProduit().getLibelle());
//			achatResp.setPrix(achat.getProduit().getPrix());
//			achatResp.setDate(achat.getDateAchat().toString());
			achatResp.calculTotal();
			clientResp.getAchats().add(achatResp);
		}

		return clientResp;
	}
}
