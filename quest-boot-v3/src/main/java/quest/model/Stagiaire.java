package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import quest.view.Views;

@Entity
@Table(name = "stagiaire")
public class Stagiaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;

	@Column(length = 25, nullable = false)
	@NotBlank(message = "Le nom ne peut pas etre vide")
	@NotEmpty(message = "Le nom ne peut pas etre null...")
	@Size(min = 5, max = 25, message = "Le nom doit faire entre 5 et 25 lettres")
	@JsonView(Views.Common.class)
	private String nom;

	@Column(length = 25, nullable = false)
	@JsonView(Views.Common.class)
	private String prenom;

	@Column(length = 25, nullable = false)
	@Size(min = 8)
	@JsonView(Views.Common.class)
	private String email;

	@Version
	@JsonView(Views.Stagiaire.class)
	private int version;

	@ManyToOne
	@JoinColumn(name = "filiere")
	@JsonView(Views.Stagiaire.class)
	private Filiere filiere;

	@OneToOne(mappedBy = "stagiaire")
	@JsonView(Views.Stagiaire.class)
	private Ordinateur ordinateur;

	public Stagiaire() {
	}

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
