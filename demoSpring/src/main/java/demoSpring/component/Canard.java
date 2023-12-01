package demoSpring.component;

import java.util.Random;

public class Canard {

	
	public Canard() {}
	
	
	public void faireBlague() 
	{
		Random random = new Random();
		if(random.nextInt(3)==0) //1 chance sur trois de faire une fausse note
		{
			throw new RuntimeException("J'ai oublié la blague....");
		}
		System.out.println("C'est toto qui....");
	}
	
	public int fonctionQuiRetourneUnInt() 
	{
		System.out.println("Fonction qui retourne toujours 42");
		return 42;
	} 
}
