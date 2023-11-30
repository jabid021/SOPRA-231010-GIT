package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.IMusicien;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

			IMusicien guitariste = (IMusicien) ctx.getBean("guitariste");
			IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
			IMusicien flutiste = (IMusicien) ctx.getBean("flutiste");
			
		
			guitariste.jouer();
			pianiste.jouer();
			flutiste.jouer();
	}

}
