package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //Obligatoire
public class Boisson {
	

	@Id //Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //SEMI-Obligatoire (SI ON VEUT DE L'AUTO-INCREMENT)*
	private Integer numero;
	private String libelle;
	private double prix;
	private boolean alcool;
	private Integer cl;
	
	//Constructeur Obligatoire
	public Boisson() {}
	
	public Boisson(String libelle, double prix, boolean alcool, Integer cl) {
		this.libelle = libelle;
		this.prix = prix;
		this.alcool = alcool;
		this.cl = cl;
	}

	public Boisson(Integer numero, String libelle, double prix, boolean alcool, Integer cl) {
		this.numero = numero;
		this.libelle = libelle;
		this.prix = prix;
		this.alcool = alcool;
		this.cl = cl;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer id) {
		this.numero = id;
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

	public boolean isAlcool() {
		return alcool;
	}

	public void setAlcool(boolean alcool) {
		this.alcool = alcool;
	}

	public Integer getCl() {
		return cl;
	}

	public void setCl(Integer cl) {
		this.cl = cl;
	}

	@Override
	public String toString() {
		return "Boisson [numero=" + numero + ", libelle=" + libelle + ", prix=" + prix + ", alcool=" + alcool + ", cl=" + cl
				+ "]";
	}




	
	
	
	
	

}
