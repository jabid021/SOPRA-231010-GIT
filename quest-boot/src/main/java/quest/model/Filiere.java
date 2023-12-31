package quest.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import quest.view.Views;
@Entity
@Table(name="filiere")
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;
	
	@Column(length = 50,nullable = false)
	@JsonView(Views.Common.class)
	private String libelle;
	
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private LocalDate debut;
	
	@Column(nullable = false)
	@JsonView(Views.Common.class)
	private LocalDate fin;
	
	@OneToMany(mappedBy = "filiere")
	@JsonView(Views.FiliereWithStagiaires.class)
	private List<Stagiaire> eleves; 
	
	@ManyToMany
	@JoinTable(name="module")
	@JsonView(Views.FiliereWithMatieres.class)
	private List<Matiere> matieres;
	
	public Filiere() {}
	
	public Filiere(Integer id, String libelle, LocalDate debut, LocalDate fin) {
		this.id = id;
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}
	
	public Filiere(String libelle, LocalDate debut, LocalDate fin) {
		this.libelle = libelle;
		this.debut = debut;
		this.fin = fin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	
	public List<Stagiaire> getEleves() {
		return eleves;
	}

	public void setEleves(List<Stagiaire> eleves) {
		this.eleves = eleves;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	
	public String getLabelSelect() 
	{
		return id+" - "+libelle+" ("+debut+" - "+fin+")";
	} 
	
	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", debut=" + debut + ", fin=" + fin + "]";
	}
	
	
	
	
}
