package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Filiere;
import model.Matiere;
import model.Stagiaire;

public class TestMapping {

	public static void main(String[] args) {
	
		Matiere m1 = new Matiere("Spring Core",7489);
		Matiere m2= new Matiere("Spring MVC",9415);
		Matiere m3 = new Matiere("Spring Boot",7423);
		
		Filiere filiere = new Filiere(2,null,null,null);
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");
		
		EntityManager em = emf.createEntityManager();
		Filiere f2 = em.find(Filiere.class, 2);
		Stagiaire stagiaire = new Stagiaire("Toto", "Titi", "monemail@gmail.com", f2);
		
	
		//JPQL => Java Progra Query Lang 
		//SELECT * from drink
		//List<Stagiaire> stagiaires  = em.createQuery("from Stagiaire").getResultList();
		
		
	/*	Query requete  = em.createQuery("SELECT s from Stagiaire s where s.prenom like :mot");
		requete.setParameter("mot", "%A%");*/
		//List<Stagiaire> stagiaires =requete.getResultList();
		
		
		List<Stagiaire> stagiaires = em.createQuery("SELECT s from Stagiaire s where s.prenom like :mot").setParameter("mot", "%Axvxcvxcgx%").getResultList();
		//System.out.println(stagiaires);
		//List<Stagiaire> stagiaires  = em.createQuery("SELECT s from Stagiaire s where s.prenom like '%A%'").getResultList();
		
		Stagiaire stagiaireConnected = (Stagiaire) em.createQuery("from Stagiaire s where s.email=:mail and prenom=:prenom").setParameter("mail","monemail@gmail.com").setParameter("prenom","Titefddfi").getSingleResult();	
		
		System.out.println("Connected : "+stagiaireConnected);
		
		for(Stagiaire s : stagiaires) 
		{
			System.out.println(s);
		}
		
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
			//em.persist(filiere);
			//em.persist(stagiaire);
			//em.persist(m2);
			//em.persist(m3);
		//stagiaire=em.find(Stagiaire.class,stagiaire.getId());
		
		//	stagiaire = em.merge(stagiaire);
	
		//	tx.commit();
		
		em.close();
	
		emf.close();
		
		//Objets managed 
		//persist(x) => x sera managed
					//Si X fait reference à un objet Y, Y doit etre managed ou avoir un id deja existant
					//Si la classe est en auto increment ID, x ne doit pas avoir d'id au moment de l'insert
		//x = find(Class.class,id)  => x est managed
		//x = em.createQuery().singleResult => x est managed
		//List<X> listeX = em.createQuery().getResultList(); => chaque element de listeX sera managed
		//y = em.merge(x) => update / insert x en fonction de si l'id est present (!=null) et qu'il existe
						// x est pas managed, y l'est ! => em.remove(y)
		//em.remove(X) => X DOIT ETRE managed !
		
		
		
	}

}
