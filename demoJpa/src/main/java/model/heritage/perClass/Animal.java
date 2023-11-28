package model.heritage.perClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq",sequenceName = "animal_seq")
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
	@Column(name="id_animal")
	protected Integer id;
	protected String couleur;
	
	public Animal() {
	}

	public Animal(String couleur) {
		this.couleur = couleur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
