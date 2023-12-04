package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.model.Guitariste;
import orchestre.model.IMusicien;

public class Test {
	@Autowired
	IMusicien guitariste;

	@Autowired
	IMusicien pianiste;

	@Autowired
	IMusicien flutiste;

	/*@Autowired
	@Qualifier("musicien")
	IMusicien flutiste2;

	@Autowired
	@Qualifier("guitaristeXML")
	IMusicien guitariste2;
*/

	public void run(String[] ...args) {

		/*
		IMusicien guitariste = (IMusicien) ctx.getBean("guitariste");
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste = (IMusicien) ctx.getBean("flutiste");
		IMusicien flutiste2 = (IMusicien) ctx.getBean("musicien");
		IMusicien guitariste2 = (IMusicien) ctx.getBean("guitaristeXML");
		 */	
		/*guitariste.jouer();
		pianiste.jouer();
		flutiste.jouer();
		flutiste2.jouer();
		guitariste2.jouer();
		*/
		try { 
			guitariste.jouer();
		}
		catch(Exception e) 
		{
			//e.printStackTrace();
		}
		
	//	guitariste.toString();
		
	//	guitariste.playStyle("...");

	}

}
