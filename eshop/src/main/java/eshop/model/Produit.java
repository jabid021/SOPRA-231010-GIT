package eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//JPA Va creer une table "produit" (pour Windows / Linux), "Produit" 
@Table(name="product")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // col int id
	
	@Column(name="label", nullable = false, length = 50)
	private String libelle; //varchar (255) libelle 
	
	@Column(name="price", nullable=false,columnDefinition = "DECIMAL(6,2)")
	private double prix; // double  prix
	
	
	public Produit() {}

	
	public Produit(String libelle, double prix) {
		this.libelle = libelle;
		this.prix = prix;
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

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + "]";
	}
	
}
