package eshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import eshop.model.Achat;
import eshop.model.Client;

public class ClientResponse {

	private Integer id;
	private String nom,prenom,numero,voie,ville,cp;
	private List<AchatResponse> achats = new ArrayList<>();
	
	public ClientResponse() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public List<AchatResponse> getAchats() {
		return achats;
	}

	public void setAchats(List<AchatResponse> achats) {
		this.achats = achats;
	}
	
	public void fromClient(Client client) {
		BeanUtils.copyProperties(client, this);
		BeanUtils.copyProperties(client.getAdresse(), this);

		for (Achat achat : client.getAchats()) {
			AchatResponse achatResp = new AchatResponse();
			achatResp.fromAchat(achat);
			achatResp.calculTotal();
			
			this.getAchats().add(achatResp);
		}
	}
}
