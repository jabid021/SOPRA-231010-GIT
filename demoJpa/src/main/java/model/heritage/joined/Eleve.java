package model.heritage.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="id_student")
public class Eleve extends Sorcier {

	private int promotion;
	public Eleve() {}
	public Eleve(String nom, String prenom, int promotion) {
		super(nom, prenom);
		this.promotion = promotion;
	}
	public int getPromotion() {
		return promotion;
	}
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", promotion=" + promotion + "]";
	}
	
}
