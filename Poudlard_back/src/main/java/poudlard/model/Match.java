package poudlard.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
	private Integer id;
	private Integer scoreDom; 
	private Integer scoreExt; 
	private LocalDate rencontre; 
	private LocalTime horaire;
	private Equipe exterieur;
	private Equipe domicile;

	public Match(Integer id,Integer scoreDom, Integer scoreExt, LocalDate rencontre, LocalTime horaire, Equipe exterieur, Equipe domicile) {
		this.id=id;
		this.scoreDom = scoreDom;
		this.scoreExt = scoreExt;
		this.rencontre = rencontre;
		this.horaire = horaire;
		this.exterieur = exterieur;
		this.domicile = domicile;
	}
	
	public Match(LocalDate rencontre, LocalTime horaire, Equipe exterieur, Equipe domicile) {
		
		this.rencontre = rencontre;
		this.horaire = horaire;
		this.exterieur = exterieur;
		this.domicile = domicile;
	}
	public Equipe getExterieur() {
		return exterieur;
	}
	public void setExterieur(Equipe exterieur) {
		this.exterieur = exterieur;
	}
	public Equipe getDomicile() {
		return domicile;
	}
	public void setDomicile(Equipe domicile) {
		this.domicile = domicile;
	}
	
	public Integer getScoreDom() {
		return scoreDom;
	}

	public void setScoreDom(Integer scoreDom) {
		this.scoreDom = scoreDom;
	}

	public Integer getScoreExt() {
		return scoreExt;
	}

	public void setScoreExt(Integer scoreExt) {
		this.scoreExt = scoreExt;
	}

	public LocalDate getRencontre() {
		return rencontre;
	}
	public void setRencontre(LocalDate rencontre) {
		this.rencontre = rencontre;
	}
	public LocalTime getHoraire() {
		return horaire;
	}
	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", scoreDom=" + scoreDom + ", scoreExt=" + scoreExt + ", rencontre=" + rencontre
				+ ", horaire=" + horaire + ", exterieur=" + exterieur + ", domicile=" + domicile + "]";
	}

	
} 



