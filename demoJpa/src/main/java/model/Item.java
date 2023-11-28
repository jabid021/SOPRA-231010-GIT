package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	
	@ManyToMany(mappedBy="inventaire")
	private List<Personnage> possesseurs=new ArrayList();
	
	public Item() {
	}

	public Item(String libelle) {
		this.libelle = libelle;
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

	
	public List<Personnage> getPossesseurs() {
		return possesseurs;
	}

	public void setPossesseurs(List<Personnage> possesseurs) {
		this.possesseurs = possesseurs;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
}
