package poudlard.model;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Joueur {

	//---------
	//ATTRIBUTS
	//---------
	//Personnal Attributs
	private Integer id;
	private boolean capitaine;
	private LocalDate admission;
	//Other Attributs
	private Eleve eleve;
	private Equipe equipe;
	private Poste poste;

	//-------------
	//CONSTRUCTEURS
	//-------------
	//1
	public Joueur(LocalDate admission, Eleve eleve, Equipe equipe, Poste poste) {
		this.capitaine = false;
		this.admission = admission;
		this.eleve = eleve;
		this.equipe = equipe;
		this.poste = poste;
	}
	//2
	
	public Joueur(Integer id,boolean capitaine, LocalDate admission, Eleve eleve, Equipe equipe, Poste poste) {
		this.id=id;
		this.capitaine = capitaine;
		this.admission = admission;
		this.eleve = eleve;
		this.equipe = equipe;
		this.poste = poste;
	}
	
	public Joueur(boolean capitaine, LocalDate admission, Eleve eleve, Equipe equipe, Poste poste) {
		this.capitaine = capitaine;
		this.admission = admission;
		this.eleve = eleve;
		this.equipe = equipe;
		this.poste = poste;
	}

	//-------
	//GETTERS
	//-------
	public boolean isCapitaine() { return capitaine; }
	public LocalDate getAdmission() { return admission; }
	public Eleve getEleve() { return eleve; }
	public Equipe getEquipe() {	return equipe; }	
	public Poste getPoste() { return poste;	}
	public Integer getId() {return id;}

	//-------
	//SETTERS
	//-------
	public void setCapitaine(boolean capitaine) { this.capitaine = capitaine; }
	public void setAdmission(LocalDate admission) {	this.admission = admission; }
	public void setEleve(Eleve eleve) {	this.eleve = eleve; }
	public void setEquipe(Equipe equipe) { this.equipe = equipe; }
	public void setPoste(Poste poste) {	this.poste = poste;	}
	public void setId(Integer id) {this.id = id;}
	//--------
	//METHODES
	//--------
	



	

	public void printPeriod() {
		Period period = Period.between(admission, LocalDate.now());

		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();

		System.out.println("Dans l'équipe depuis : " + years + " ans " + months + " mois " + days + " jours");
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", capitaine=" + capitaine + ", admission=" + admission + ", eleve=" + eleve
				+ ", equipe=" + equipe + ", poste=" + poste + "]";
	}

	public long printTime() {
		return ChronoUnit.DAYS.between(admission, LocalDate.now());
	}
}
