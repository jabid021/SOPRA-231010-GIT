package hopital.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visite")
public class Visite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	@ManyToOne
	@JoinColumn(name="id_patient")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="id_medecin")
	private Medecin medecin;
	private double prix=20;
	@Column(name="date_visite")
	private LocalDate dateVisite;
	private int salle;
	
	public Visite() {}
	
	public Visite(Integer numero, Patient patient, Medecin medecin, double prix, LocalDate dateVisite, int salle) {
		this.numero = numero;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = prix;
		this.dateVisite = dateVisite;
		this.salle = salle;
	}
	
	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.dateVisite = LocalDate.now();
		this.salle = medecin.getSalle();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(LocalDate dateVisite) {
		this.dateVisite = dateVisite;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", patient=" + patient + ", medecin=" + medecin.getId() + ", prix=" + prix
				+ ", dateVisite=" + dateVisite + ", salle=" + salle + "]";
	}
	
	
	
	
}
