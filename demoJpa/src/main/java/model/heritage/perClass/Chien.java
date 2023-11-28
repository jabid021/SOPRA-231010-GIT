package model.heritage.perClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dog")
public class Chien extends Animal{

	private int score;
	public Chien() {}
	

	public Chien(String couleur, int score) {
		super(couleur);
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Chien [id=" + id + ", couleur=" + couleur + ", score=" + score + "]";
	}
	
}
