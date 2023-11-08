package poudlard.model;

public class Animal {

	private String nom;
	private String race;

	public Animal(String nom, String race) {
		this.nom = nom;
		this.race = race;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public String toString() {
		return "Animal [nom=" + nom + ", race=" + race + "]";
	}

}
