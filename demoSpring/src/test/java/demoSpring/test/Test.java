package demoSpring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import demoSpring.component.Canard;
import demoSpring.component.JAPA;

public class Test {

	@Autowired
	@Qualifier("nouveauNomDuBean")
	JAPA maConfigJPA;
	
	@Autowired
	Canard donald;
	public void run(String[] ...args) {
		
		
		
		/*JAPA maConfigJPA = (JAPA) ctx.getBean("JAPA");*/
		
		/*System.out.println("Voici la config quiva etre use : ");
		System.out.println("url : "+maConfigJPA.getUrl());
		System.out.println("login : "+maConfigJPA.getLogin());
		System.out.println("password : "+maConfigJPA.getPassword());*/

		//daoSorcier = (IDAO) ctx.getBean("daosorcier");
		
		//maConfigJPA.getDao().findById();
		

		donald.faireBlague();
		
		donald.fonctionQuiRetourneUnInt();
		//Before
		//After
		//After returning
		//After throwing
	}

}
