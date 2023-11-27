package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("humain")
public class Humain extends Personnage {

	public Humain() {
	}
	public Humain(Integer id, String nom, LocalDate creation,Arme arme,Monture monture,Boisson fav) {
		super(id, nom, creation,arme,monture,fav);
	}

	public Humain(String nom, LocalDate creation,Arme arme,Monture monture,Boisson fav) {
		super(nom, creation,arme,monture,fav);
	}
	@Override
	public String toString() {
		return "Humain [id=" + id + ", nom=" + nom + ", creation=" + creation + ", arme=" + arme + ", monture="
				+ monture + ", fav=" + fav + "]";
	}
	
	

	
	
	
}
