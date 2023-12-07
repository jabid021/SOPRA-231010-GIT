package eshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
//JPA Va creer une table "produit" (pour Windows / Linux), "Produit" 
@Table(name="product")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // col int id
	
	@Column(name="label", nullable = false, length = 50)
	@NotEmpty(message = "Le libelle ne peut pas etre null")
	@NotBlank(message = "Le libelle ne peut pas etre vide")
	private String libelle; //varchar (255) libelle 
	
	@Column(name="price", nullable=false,columnDefinition = "DECIMAL(6,2)")
	@Min(value=100, message = "Prix trop bas (minimum 100€)")
	@Max(value=10000, message = "Prix trop bas (maximum 10.000€)")
	private double prix; // double  prix
	
	@ManyToOne
	@JoinColumn(name="vendeur", nullable = false)
	private Fournisseur fournisseur;
	
	
	@OneToMany(mappedBy = "produit")
	private List<Achat> ventes;
	
	public Produit() {}

	
	public Produit(String libelle, double prix,Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = prix;
		this.fournisseur=fournisseur;
	}
	


	public Produit(Integer id, String libelle, double prix, Fournisseur fournisseur) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	

	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public List<Achat> getVentes() {
		return ventes;
	}


	public void setVentes(List<Achat> ventes) {
		this.ventes = ventes;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", fournisseur="+fournisseur+"]";
	}
	
}
