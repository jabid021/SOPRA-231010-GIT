package demoSpring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demoSpring.config.AppConfig;

public class SpringApplication {

	
	public static void demoFonctionParamOption(int ...nb) 
	{
		System.out.println(nb);
	}
	
	public static void main(String[] args) {
		demoFonctionParamOption();
		
		//Si config de base en XML : 
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBeanFactory().createBean(Test.class).run();
	
		ctx.close();
	}

}
