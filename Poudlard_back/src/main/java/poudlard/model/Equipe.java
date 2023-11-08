package poudlard.model;

public class Equipe {
	
	private Integer id;
	private String libelle ;
	
	private Maison maison ;

	public Equipe(String libelle, Maison maison) {

		this.libelle = libelle;
		this.maison = maison;
	}

	public Equipe(Integer id,String libelle, Maison maison) {

		this.id=id;
		this.libelle = libelle;
		this.maison = maison;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", libelle=" + libelle + ", maison=" + maison + "]";
	}


	
	

}
