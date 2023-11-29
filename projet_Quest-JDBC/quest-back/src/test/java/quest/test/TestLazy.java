package quest.test;

import java.util.List;

import javax.persistence.EntityManager;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Stagiaire;

public class TestLazy {

	public static List<Stagiaire> StagiairesApple()
	{
		List<Stagiaire> stagiaires;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		stagiaires= em.createQuery(" Select s from Stagiaire s where s.ordinateur.marque='Apple'").getResultList();
		
		em.close();
		return stagiaires;
	} 
	
	
	
	public static List<Filiere> showLazy()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		filieres= em.createQuery("SELECT f from Filiere f").getResultList();
		
		em.close();
		return filieres;
	} 
	
	//Acces aux stagiaires APRES le em.close() ❌
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas le filtre ❌
	//Si plusieurs stagiaires ont un A dans leur prenom dans une meme filiere, jpa return plusieurs fois la filiere ❌
	
	public static List<Filiere> showFilter()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		filieres= em.createQuery("SELECT f from Filiere f join f.eleves stagiaires where stagiaires.prenom like '%A%'").getResultList();
		
		em.close();
		return filieres;
	} 
	
	
	public static void main(String[] args) {
		
		
		//System.out.println(StagiairesApple());
		
		
		List<Filiere> filieres = showFilter();
		System.out.println("Liste des filieres :  ");
		for(Filiere f : filieres) 
		{
			System.out.println(f);
			System.out.println("Liste des presences : ");
			//System.out.println(f.getEleves());
			System.out.println("-------");
		}
	}
		
}
