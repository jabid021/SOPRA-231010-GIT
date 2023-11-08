package poudlard.model;

public class Professeur extends Sorcier{

	public Professeur(Integer id,String login, String password, String nom, String prenom) {
		super(id,login, password, nom, prenom);

	}
	
	public Professeur(String login, String password, String nom, String prenom) {
		super(login, password, nom, prenom);

	}

	@Override
	public String toString() {
		return "Professeur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}

	

}
