package poudlard.model;

public class Maison {
	private Integer id;
	private String nom ; 
	private int points ; 
	private Professeur professeur ;
	

	public Maison(Integer id,String nom, int points, Professeur professeur) {
		this.id=id;
		this.nom = nom;
		this.points = points;
		this.professeur = professeur;
	}
	
	public Maison(String nom, int points, Professeur professeur) {
		this.nom = nom;
		this.points = points;
		this.professeur = professeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Maison [id=" + id + ", nom=" + nom + ", points=" + points + ", professeur=" + professeur + "]";
	}

	
	
	
}
