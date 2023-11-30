package demoSpring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demoSpring.dao.IDAO;
import demoSpring.dao.JAPA;

public class Test {

	static IDAO daoSorcier;
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		JAPA maConfigJPA = (JAPA) ctx.getBean("JAPA");
		
		System.out.println("Voici la config quiva etre use : ");
		System.out.println("url : "+maConfigJPA.getUrl());
		System.out.println("login : "+maConfigJPA.getLogin());
		System.out.println("password : "+maConfigJPA.getPassword());

		//daoSorcier = (IDAO) ctx.getBean("daosorcier");
		
		maConfigJPA.getDao().findById();
		

	}

}
