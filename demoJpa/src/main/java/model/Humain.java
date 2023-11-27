package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("humain")
public class Humain extends Race {

	public Humain() {
	}
	public Humain(Integer id, String nom, LocalDate creation,Arme arme) {
		super(id, nom, creation,arme);
	}

	public Humain(String nom, LocalDate creation,Arme arme) {
		super(nom, creation,arme);
	}
	@Override
	public String toString() {
		return "Humain [id=" + id + ", nom=" + nom + ", creation=" + creation + ", arme=" + arme + "]";
	}
	

	
	
	
}
