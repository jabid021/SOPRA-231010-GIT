package quest.model;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import quest.view.Views;

@Entity
@Table(name = "ordinateur")
public class Ordinateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private Integer id;

	@Column(length = 100, nullable = false)
	@JsonView(Views.Common.class)
	private String marque;

	@JsonView(Views.Common.class)
	private int ram;

	@OneToOne
	@JoinColumn(name = "stagiaire")
	@JsonView(Views.Ordinateur.class)
	private Stagiaire stagiaire;

	public Ordinateur() {
	}

	public Ordinateur(Integer id, String marque, int ram, Stagiaire stagiaire) {
		this.id = id;
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}

	public Ordinateur(String marque, int ram, Stagiaire stagiaire) {
		this.marque = marque;
		this.ram = ram;
		this.stagiaire = stagiaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", ram=" + ram + ", stagiaire=" + stagiaire + "]";
	}

}
