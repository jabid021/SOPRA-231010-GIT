package demoSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class DemoAspectCanard {

	//Doit toujours se lancer avant une blague
	public void sePreparer() 
	{
		System.out.println("Tout le monde attend la blague du canard");
	}


	//Doit toujours se lancer apres une blague
	public void finBlague() 
	{
		System.out.println("La blague est terminee");
	}
	
	public void autoursBlague(ProceedingJoinPoint pj) throws Throwable
	{
		System.out.println("Tout le monde attend la blague du canard");
		
		pj.proceed(); // equivalent de canard.faireBlague();
		
		System.out.println("La blague est terminee");
	}

	//Doit se lancer apres une blague reussie
	public void rire() 
	{
		System.out.println("AHAHAHAHAHAHAH");
	}

	//Doit se lancer apres une blague rate
	public void pasContent() 
	{
		System.out.println("Bouuuuuuuuuh");
	}



	public void everywhere() 
	{
		System.out.println("-------------");
	}



	public void demoApresReturn(int nb) 
	{
		System.out.println("La fonction a return "+nb);
	}

}
