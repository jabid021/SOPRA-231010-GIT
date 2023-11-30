package quest.test;

import java.time.LocalDate;
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


	//Acces aux stagiaires APRES le em.close() ❌
	//Impossible de faire des filtres sur les eleves des filieres ❌
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
	//On ne recup plus les filieres qui ne valident pas le filtre ❌*
	//Si plusieurs stagiaires ont un A dans leur prenom dans une meme filiere, jpa return plusieurs fois la filiere ❌

	public static List<Filiere> showFilter()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select f from Filiere f JOIN f.eleves s where s.prenom like '%A%'").getResultList();

		em.close();
		return filieres;
	} 


	//Acces aux stagiaires APRES le em.close() ❌
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas le filtre ❌*
	//Si plusieurs stagiaires ont un A dans leur prenom dans une meme filiere, jpa ne return pas plusieurs fois la filiere ✔
	public static List<Filiere> showFilterDistinct()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f join f.eleves s where s.prenom like '%A%'").getResultList();

		em.close();
		return filieres;
	} 



	//On veut recup toutes les filieres de la bdd et si elles en ont, recup aussi leur liste d'eleves

	//Acces aux stagiaires APRES le em.close() ❌
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas la jointure ❌
	//Si plusieurs stagiaires sont dans la filiere, jpa ne return plus plusieurs fois la filiere ✔
	public static List<Filiere> ShowAllFilieres()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f join f.eleves").getResultList();

		em.close();
		return filieres;
	} 

	//Acces aux stagiaires APRES le em.close() ❌
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas la jointure ✔
	//Si plusieurs stagiaires sont dans la filiere, jpa ne return plus plusieurs fois la filiere ✔
	public static List<Filiere> ShowAllFilieresLEFT()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f LEFT join f.eleves").getResultList();

		em.close();
		return filieres;
	} 

	//Acces aux stagiaires APRES le em.close() ✔
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas la jointure ❌
	//Si plusieurs stagiaires sont dans la filiere, jpa ne return plus plusieurs fois la filiere ✔
	public static List<Filiere> ShowAllFiliereWithStagiairesMinONEStagiaire()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f join FETCH f.eleves").getResultList();

		em.close();
		return filieres;
	} 


	//Acces aux stagiaires APRES le em.close() ✔
	//Possible de faire des filtres sur les eleves des filieres ✔
	//On ne recup plus les filieres qui ne valident pas la jointure ✔
	//Si plusieurs stagiaires sont dans la filiere, jpa ne return plus plusieurs fois la filiere ✔
	public static List<Filiere> ShowAllFiliereWithStagiaires()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f LEFT join FETCH f.eleves").getResultList();

		em.close();
		return filieres;
	} 
	
	
	
	public static void exempleJPQL()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		//CombienDeStagiaireAvecUnA
		
		Long nb = (Long) em.createQuery("SELECT COUNT(s) from Stagiaire s where s.prenom like '%A%'").getSingleResult();
		System.out.println(nb);
		//Filiere la plus ancienne
		LocalDate min= (LocalDate) em.createQuery("SELECT MIN(f.debut) from Filiere f").getSingleResult();
		System.out.println(min);
		em.close();	
	} 
	
	
	public static List<Filiere> ShowAllFiliereWithMatieres()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f LEFT join FETCH f.matieres").getResultList();

		em.close();
		return filieres;
	} 
	
	
	
	
	public static List<Filiere> ShowAllFiliereWithMatieresAndEleveNotWorking()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres= em.createQuery("select DISTINCT f from Filiere f LEFT join FETCH f.matieres LEFT join FETCH f.eleves").getResultList();

		em.close();
		return filieres;
	} 
	
	
	public static List<Filiere> ShowAllFiliereWithMatieresAndEleve()
	{
		List<Filiere> filieres;
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		filieres = em.createQuery("select DISTINCT f from Filiere f LEFT join FETCH f.matieres ").getResultList();
		filieres = em.createQuery("select DISTINCT f from Filiere f LEFT join FETCH f.eleves").getResultList();

		em.close();
		return filieres;
	} 
	
	public static void main(String[] args) {


		//System.out.println(StagiairesApple());
		exempleJPQL();

		List<Filiere> filieres = ShowAllFiliereWithMatieresAndEleve();
		System.out.println("Liste des filieres :  ("+(filieres.size())+")");
		for(Filiere f : filieres) 
		{
			System.out.println(f);
			System.out.println("Liste des presences : ("+f.getEleves().size()+") eleves !");
			System.out.println(f.getEleves());
			System.out.println("-------");
			
			System.out.println("Liste de ses matieres : ("+f.getMatieres().size()+") modules dans cette filiere !");
			System.out.println(f.getMatieres());
		}
	}

}
