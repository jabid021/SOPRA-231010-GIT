package quest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import quest.view.Views;

@Entity
@Table(name="stagiaire")
public class Stagiaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message="Le nom ne peut pas etre vide")
	@NotEmpty(message="Le nom ne peut pas etre null...") 
	@Size(min=5, max = 25 , message = "Le nom doit faire entre 5 et 25 lettres")
	@JsonView(Views.Common.class)
	private String nom;
	
	@Column(length = 25, nullable = false)
	@JsonView(Views.Common.class)
	private String prenom;
	
	@Column(length = 25, nullable = false)
	@Size(min=8)
	@JsonView(Views.Common.class)
	private String email;
	
	@Version
	@JsonView(Views.Stagiaire.class)
	private int version;
	
	
	@ManyToOne
	@JoinColumn(name="filiere",nullable = false)
	@JsonView(Views.Stagiaire.class)
	private Filiere filiere;
	
	
	@OneToOne(mappedBy = "stagiaire")
	@JsonView(Views.Stagiaire.class)
	private Ordinateur ordinateur;
	
	public Stagiaire() {}
	public Stagiaire(Integer id, String nom, String prenom, String email, Filiere filiere) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.filiere = filiere;
	}

	public Stagiaire(String nom, String prenom, String email, Filiere filiere) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.filiere = filiere;
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

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}
	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", filiere="
				+ filiere + "]";
	}
	
	
}
