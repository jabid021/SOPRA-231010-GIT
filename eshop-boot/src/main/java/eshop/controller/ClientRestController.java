package eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.controller.dto.ClientResponse;
import eshop.dao.IDAOPersonne;
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

//		BeanUtils.copyProperties(client, clientResp);
//		BeanUtils.copyProperties(client.getAdresse(), clientResp);
//
//		for (Achat achat : client.getAchats()) {
//			AchatResponse achatResp = new AchatResponse();
//			BeanUtils.copyProperties(achat, achatResp);
//			BeanUtils.copyProperties(achat.getProduit(), achatResp);
//			achatResp.calculTotal();
//			clientResp.getAchats().add(achatResp);
//		}

		clientResp.fromClient(client);

		return clientResp;
	}
}
