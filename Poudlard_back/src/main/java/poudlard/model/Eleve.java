package poudlard.model;

public class Eleve extends Sorcier{

	
	private int promotion;
	private Animal familier;
	private Maison maison;

	public Eleve(String login, String password, String nom, String prenom, int promotion, Animal familier) {
		super(login, password, nom, prenom);
		this.promotion = promotion;
		this.familier = familier;
	}

	public Eleve(String login, String password, String nom, String prenom, int promotion, Animal familier,Maison maison) {
		super(login, password, nom, prenom);
		this.promotion = promotion;
		this.familier = familier;
		this.maison=maison;
	}

	public Eleve(Integer id,String login, String password, String nom, String prenom, int promotion, Animal familier,Maison maison) {
		super(id,login, password, nom, prenom);
		this.promotion = promotion;
		this.familier = familier;
		this.maison=maison;
	}


	public int getPromotion() {
		return promotion;
	}




	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}




	public Animal getFamilier() {
		return familier;
	}




	public void setFamilier(Animal familier) {
		this.familier = familier;
	}




	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", promotion=" + promotion + ", familier=" + familier + ", maison=" + maison + "]";
	}

	
	

	




}
