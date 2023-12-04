package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {

	
	@Pointcut("execution(public void orchestre.model.Guitariste.jouer())")
	public void pointcutGuitariste() {}
	
	
	@Before("pointcutGuitariste()")
	public void installer()
	{
		System.out.println("Le public s'installe");
	}
	
	@AfterReturning("pointcutGuitariste()")
	public void applaudir()
	{
		System.out.println("Le public applaudit");
	}
	
	@AfterThrowing("execution(public void orchestre.model.Guitariste.jouer())")
	public void huer()
	{
		System.out.println("Le public jette des tomates");
	}
	
	
	
	
	
	@AfterReturning(returning="msg" , pointcut = "execution(public String orchestre.model.Guitariste.toString())")
	public void afterToStringGuitariste(String msg) 
	{
		System.out.println(msg);
		System.out.println("Le guitariste vient de se presenter");
	}
	
	@Before("execution(public void orchestre.model.Guitariste.playStyle(String)) && args(styleRecup)")
	public void beforePlayStyle(String styleRecup) 
	{
		if(styleRecup.equals("Rock")) 
		{
			System.out.println("Le public est impatient");
		}
		else 
		{
			System.out.println("osef");
		}
	}
	
}
