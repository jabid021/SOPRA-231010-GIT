package model.heritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name="id_teacher")
public class Professeur extends Sorcier {
	
	@Column(nullable = false)
	private String salle;
	
	
	public Professeur() {}


	public Professeur(String nom, String prenom, String salle) {
		super(nom, prenom);
		this.salle = salle;
	}


	public String getSalle() {
		return salle;
	}


	public void setSalle(String salle) {
		this.salle = salle;
	}


	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salle=" + salle + "]";
	}
	
}
