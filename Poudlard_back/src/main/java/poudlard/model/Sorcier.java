package poudlard.model;

public abstract class Sorcier {
	
	protected Integer id;
	protected String login;
	protected String password;
	protected String nom;
	protected String prenom;

	public Sorcier(Integer id,String login, String password, String nom, String prenom) {
		this.id=id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Sorcier(String login, String password, String nom, String prenom) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
