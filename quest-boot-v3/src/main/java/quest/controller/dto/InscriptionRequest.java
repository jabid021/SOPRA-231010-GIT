package quest.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class InscriptionRequest {
	@NotEmpty
	@Size(min = 5)
	private String nom;
	private String prenom;
	private String email;
	@NotEmpty
	private String username;
	@NotEmpty
	@Size(min = 5)
	private String password;

	public InscriptionRequest() {
		super();
	}

	public InscriptionRequest(String nom, String prenom, String email, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
