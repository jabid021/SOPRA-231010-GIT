package quest.demoJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VoitureTest {

	@BeforeClass
	public static void debutTestVoiture() 
	{
		System.out.println("Debut des tests de la classe Voiture");
	}
	
	
	@Before
	public void allTest() 
	{
		System.out.println("Avant chaque test : ");
	}

	@Test
	public void testCreation() 
	{
		//Arrange
		//Act
		Voiture v = new Voiture();
		//Assert
		assertNotNull(v);
	}

	@Test
	public void testStart() 
	{
		//Arrange
		Voiture v = new Voiture();
		//Act
		v.start(80);
		//Assert
		assertTrue(80==v.getVitesse());
		assertTrue(true==v.isMarche());
	}

	
	
	@Test
	public void testStartNegatif() 
	{
		//Arrange
		Voiture v = new Voiture();
		Voiture v2 = new Voiture();
		//Act
		v.start(80);
		v.start(-20);
		v2.start(-20);
		//Assert
		assertTrue(80==v.getVitesse());
		assertTrue(true==v.isMarche());
		
		assertEquals(null, v2.getVitesse());;
		assertTrue(false==v2.isMarche());
	}

	@Test
	public void testStop() 
	{
		//Arrange
		Voiture v = new Voiture();
		v.start(80);
		//Act
		
		v.stop();
		//Assert
		assertTrue(0==v.getVitesse());
		/*if(v.getVitesse()==0) 
		{
			fail();
		}*/
		assertTrue(false==v.isMarche());
	}
}
