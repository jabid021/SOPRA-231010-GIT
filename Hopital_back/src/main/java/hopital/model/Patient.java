package hopital.model;

import java.io.Serializable;

public class Patient implements Serializable {
	
	private Integer id;
	private String nom;
	private String prenom;
	
	public Patient(Integer id, String login, String password) {
		this.id = id;
		this.nom = login;
		this.prenom = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String login) {
		this.nom = login;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String password) {
		this.prenom = password;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	

}