package orchestre.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.config.AppConfig;

public class SpringApplication {

	
	
	public static void main(String[] args) {
		//Si config de base en XML : 
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBeanFactory().createBean(Test.class).run();
	
		ctx.close();
	}

}
