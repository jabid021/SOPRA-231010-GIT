package eshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import eshop.view.Views;

@Entity
@Table(name="achat")
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	@Column(name="date_achat")
	@JsonView(Views.Common.class)
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateAchat;
	@JsonView(Views.Common.class)
	private int quantite;
	
	
	@JoinColumn(name="client",nullable = false)
	@ManyToOne
	@JsonView(Views.ProduitWithVentes.class)
	private Client client;
	@JoinColumn(name="produit",nullable = false)
	@ManyToOne
	@JsonView(Views.ClientWithAchats.class)
	private Produit produit;
	
	
	public Achat() {}


	public Achat(LocalDate dateAchat, int quantite, Client client, Produit produit) {
		this.dateAchat = dateAchat;
		this.quantite = quantite;
		this.client = client;
		this.produit = produit;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", quantite=" + quantite + ", client=" + client
				+ ", produit=" + produit + "]";
	}
	
	
}
