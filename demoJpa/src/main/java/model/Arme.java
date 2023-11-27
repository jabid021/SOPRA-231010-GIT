package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Arme {

	@Column(length=50, name="arme_name")
	private String nom;
	
	@Column(name="arme_type",columnDefinition = "ENUM('Melee', 'Distance', 'Magique')")
	@Enumerated(EnumType.STRING)
	private TypeArme typeArme;
	
	public Arme() {}

	public Arme(String nom, TypeArme typeArme) {
		this.nom = nom;
		this.typeArme = typeArme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeArme getTypeArme() {
		return typeArme;
	}

	public void setTypeArme(TypeArme typeArme) {
		this.typeArme = typeArme;
	}

	@Override
	public String toString() {
		return "Arme [nom=" + nom + ", typeArme=" + typeArme + "]";
	}
	
	
}
