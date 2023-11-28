package model.heritage.superClass;

import javax.persistence.Entity;

@Entity
public class Voiture extends Vehicule {
	
	private String marque;

	public Voiture() {}
	
	public Voiture(int vitesse, String marque) {
		super(vitesse);
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", vitesse=" + vitesse + ", marque=" + marque + "]";
	}
	
	

}
