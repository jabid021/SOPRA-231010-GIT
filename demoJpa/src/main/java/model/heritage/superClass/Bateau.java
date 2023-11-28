package model.heritage.superClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ship")
public class Bateau extends Vehicule{
	
	@Column(nullable = false)
	private String etatVoiles;
	
	public Bateau() {}

	public Bateau(int vitesse, String etatVoiles) {
		super(vitesse);
		this.etatVoiles = etatVoiles;
	}

	public String getEtatVoiles() {
		return etatVoiles;
	}

	public void setEtatVoiles(String etatVoiles) {
		this.etatVoiles = etatVoiles;
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + ", vitesse=" + vitesse + ", etatVoiles=" + etatVoiles + "]";
	}
	

}
