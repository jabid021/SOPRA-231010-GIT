package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mount")
public class Monture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private int vitesse;
	
	public Monture() {}
	
	public Monture(String nom, int vitesse) {
		this.nom = nom;
		this.vitesse = vitesse;
	}

	
	public Monture(Integer id, String nom, int vitesse) {
		this.id = id;
		this.nom = nom;
		this.vitesse = vitesse;
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


	public int getVitesse() {
		return vitesse;
	}


	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}


	@Override
	public String toString() {
		return "Monture [id=" + id + ", nom=" + nom + ", vitesse=" + vitesse + "]";
	}
	
	
	

}
