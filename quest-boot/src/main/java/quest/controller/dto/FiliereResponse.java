package quest.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class FiliereResponse {
	private Integer id;
	private String titre;
	private String debut;
	private String fin;
	private List<String> matieres = new ArrayList<String>();
	private List<StagiaireResponse> stagiaires = new ArrayList<>();

	public FiliereResponse() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public List<String> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<String> matieres) {
		this.matieres = matieres;
	}

	public void addMatiere(String matiere) {
		this.matieres.add(matiere);
	}

	public List<StagiaireResponse> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<StagiaireResponse> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public void addStagiaire(StagiaireResponse stagiaire) {
		this.stagiaires.add(stagiaire);
	}

}
