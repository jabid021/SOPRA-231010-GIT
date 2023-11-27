package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity //Obligatoire
@Table(name="drink",uniqueConstraints = @UniqueConstraint(columnNames = {"label","cl"},name = "UKLabelCl"))
public class Boisson {
	

	@Id //Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //SEMI-Obligatoire (SI ON VEUT DE L'AUTO-INCREMENT)*
	private Integer numero;
	
	@Column(name="label",nullable = false,length = 25)
	private String libelle;
	
	@Column(columnDefinition = ("TEXT"))
	private String description;
	
	@Column(name="price",nullable = false,columnDefinition = "DECIMAL(4,2) default 0")
	private double prix;
	private boolean alcool;
	private Integer cl;

	
	
	//Constructeur Obligatoire
	public Boisson() {}
	
	public Boisson(String libelle, double prix, boolean alcool, Integer cl,String description) {
		this.libelle = libelle;
		this.prix = prix;
		this.alcool = alcool;
		this.cl = cl;
		this.description=description;
	}

	public Boisson(Integer numero, String libelle, double prix, boolean alcool, Integer cl,String description) {
		this.numero = numero;
		this.libelle = libelle;
		this.prix = prix;
		this.alcool = alcool;
		this.cl = cl;
		this.description=description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Boisson [numero=" + numero + ", libelle=" + libelle + ", description=" + description + ", prix=" + prix
				+ ", alcool=" + alcool + ", cl=" + cl + "]";
	}

	



	
	
	
	
	

}
