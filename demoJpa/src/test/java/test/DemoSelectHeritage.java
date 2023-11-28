package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.heritage.perClass.Animal;

public class DemoSelectHeritage {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		/*Personnage perso1 = em.find(Personnage.class, 1);
		Orc perso2 = em.find(Orc.class, 1);
		System.out.println(perso2);
		Humain perso3 = em.find(Humain.class, 2);
		System.out.println(perso3);
		*/
		
		
		/*List<Personnage> persos = em.createQuery("from Personnage").getResultList();
		System.out.println(persos);
		
		
		List<Eleve> sorciers = em.createQuery("from Eleve").getResultList();
		System.out.println(sorciers);
		
		*/
		
		
		List<Animal> animaux = em.createQuery("from Animal").getResultList();
		System.out.println(animaux);
		
		
		em.close();
		emf.close();
	}
}
