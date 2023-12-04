package eshop.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {

	@BeforeClass
	public static void beforeTests() 
	{
		System.out.println("Debut des tests SuperMaths");
	}
	
	
	@Test
	public void testInit() 
	{
		//Arrange
		SuperMaths sm;
		//Act
		sm = new SuperMaths();
		//Assert
		assertNotNull(sm);
	}
	@Test
	public void testAdd() 
	{
		SuperMaths sm = new SuperMaths();
		int result;
		
		result= sm.additionner(1, 5);
		
		assertTrue(6==result);
	}
	
	@Test
	public void testMin() 
	{
		SuperMaths sm = new SuperMaths();
		int result;
		
		result= sm.soustraire(6, 5);
		
		assertFalse(0==result);
	}
}
