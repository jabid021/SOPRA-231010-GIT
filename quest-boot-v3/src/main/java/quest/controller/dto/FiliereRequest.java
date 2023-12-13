package quest.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FiliereRequest {
	private String libelle;
	private LocalDate debut;
	private LocalDate fin;
	private List<String> eleves = new ArrayList<>();

	public FiliereRequest() {
		super();
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

	public List<String> getEleves() {
		return eleves;
	}

	public void setEleves(List<String> eleves) {
		this.eleves = eleves;
	}

}
