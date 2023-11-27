package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("orc")
public class Orc extends Personnage {

	@Column(name="strength")
	private int force;
	
	public Orc() {
	}

	public Orc(Integer id, String nom, LocalDate creation, Arme arme,int force,Monture monture,Boisson fav) {
		super(id, nom, creation,arme,monture,fav);
		this.force = force;
	}

	public Orc(String nom, LocalDate creation, Arme arme,int force,Monture monture,Boisson fav) {
		super(nom, creation,arme,monture,fav);
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	@Override
	public String toString() {
		return "Orc [id=" + id + ", nom=" + nom + ", creation=" + creation + ", arme=" + arme + ", monture=" + monture
				+ ", fav=" + fav + ", force=" + force + "]";
	}

	

	
	
	
	
	
}
