package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="race")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_race",columnDefinition = "ENUM('orc','humain')")
public abstract class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_race")
	protected Integer id;
	
	@Column(nullable = false, length = 25, unique = true)
	protected String nom;

	@Column(name="date_creation")
	protected LocalDate creation;
	
	@Embedded
	protected Arme arme; 
	
	public Race() {
	}

	public Race(Integer id, String nom, LocalDate creation,Arme arme) {
		this.id = id;
		this.nom = nom;
		this.creation = creation;
		this.arme=arme;
	}	

	public Race(String nom, LocalDate creation,Arme arme) {
		this.nom = nom;
		this.creation = creation;
		this.arme=arme;
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

	public LocalDate getCreation() {
		return creation;
	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}
	
	

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", nom=" + nom + ", creation=" + creation + ", arme=" + arme + "]";
	}

	
	
}
