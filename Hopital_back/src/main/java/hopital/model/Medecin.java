package hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte{

	@Transient
	private int salle; 
	@OneToMany(mappedBy="medecin")
	private List<Visite> visites = new ArrayList();
	
	public Medecin() {}
	
	public Medecin(Integer id, String login, String password) {
		super(id, login, password);
	}
	
	public Medecin(String login, String password) {
		super(login, password);
	}


	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", salle=" + salle + ", visites="
				+ visites + "]";
	}
	
	

}
