package hopital.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("secretaire")
public class Secretaire extends Compte {

	public Secretaire(Integer id, String login, String password) {
		super(id, login, password);
	}
	
	
	public Secretaire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	

}
