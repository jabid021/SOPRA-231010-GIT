package model.heritage.perClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat")
public class Chat extends Animal {

	private int vieRestantes;
	
	public Chat() {}

	public Chat(String couleur, int vieRestantes) {
		super(couleur);
		this.vieRestantes = vieRestantes;
	}

	public int getVieRestantes() {
		return vieRestantes;
	}

	public void setVieRestantes(int vieRestantes) {
		this.vieRestantes = vieRestantes;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", couleur=" + couleur + ", vieRestantes=" + vieRestantes + "]";
	}
	

}
