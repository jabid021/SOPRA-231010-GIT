package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="player")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_race",columnDefinition = "ENUM('orc','humain')")
public abstract class Personnage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_player")
	protected Integer id;
	
	@Column(nullable = false, length = 25, unique = true)
	protected String nom;

	@Column(name="date_creation")
	protected LocalDate creation;
	
	@Embedded
	protected Arme arme;
	
	
	@ManyToMany
	@JoinTable
	(
			name="inventaire",
			joinColumns = @JoinColumn(name="joueur") , // represente l'id de la classe actuelle (Personnage)
			inverseJoinColumns = @JoinColumn(name="objet") // represente l'id de l'autre classe (Item)
			//,uniqueConstraints = @UniqueConstraint(columnNames = {"joueur","objet"}) //impossible pour un joueur d'avoir 2 fois le meme objet !
	)
	protected List<Item> inventaire = new ArrayList();
	
	
	//une monture est lie a X perso ?
	//un perso a Y monture ?
	//One / Many
	
	@OneToOne
	@JoinColumn(name="monture", foreignKey = @ForeignKey(name="player_mount_fk"))
	protected Monture monture;
	
	
	@ManyToOne
	@JoinColumn(name="favorie", nullable=false)
	protected Boisson fav;
	
	public Personnage() {
	}

	public Personnage(Integer id, String nom, LocalDate creation,Arme arme,Monture monture,Boisson fav) {
		this.id = id;
		this.nom = nom;
		this.creation = creation;
		this.arme=arme;
		this.monture=monture;
		this.fav=fav;
	}	

	public Personnage(String nom, LocalDate creation,Arme arme,Monture monture,Boisson fav) {
		this.nom = nom;
		this.creation = creation;
		this.arme=arme;
		this.monture=monture;
		this.fav=fav;
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

	public Monture getMonture() {
		return monture;
	}

	public void setMonture(Monture monture) {
		this.monture = monture;
	}

	public Boisson getFav() {
		return fav;
	}

	public void setFav(Boisson fav) {
		this.fav = fav;
	}

	public List<Item> getInventaire() {
		return inventaire;
	}

	public void setInventaire(List<Item> inventaire) {
		this.inventaire = inventaire;
	}

	
	
	
}
