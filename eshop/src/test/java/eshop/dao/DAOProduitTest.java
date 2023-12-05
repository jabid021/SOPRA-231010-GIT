package eshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class }) 
@Transactional 
@Rollback(true) 
public class DAOProduitTest {

	@Autowired
	private IDAOProduit daoProduit;
	@Autowired
	private IDAOPersonne daoPersonne;
	
	
	@Test
	public void testInjectDAOProduit() 
	{
		assertNotNull(daoProduit);
	}
	
	
	@Test
	public void testInsert() 
	{
	//Arrange
	Fournisseur f = new Fournisseur("nom","prenom",new Adresse("numero","voie","ville","cp"),"societe");
	f = (Fournisseur) daoPersonne.save(f);
	Produit p = new Produit("libelle",50,f);
	//Act
	p = daoProduit.save(p);	
	//Assert
	Produit produitBdd =daoProduit.findById(p.getId());
	assertNotNull(produitBdd);
	assertNotNull(produitBdd.getId());
	assertEquals(p, produitBdd);
	/*assertEquals(p.getLibelle(), produitBdd.getLibelle());
	assertTrue(p.getPrix()== produitBdd.getPrix());
	assertNotNull(produitBdd.getFournisseur());
	assertEquals(p.getFournisseur(), f);
	*/
	}
	
	
	@Test
	public void testFindById() 
	{
		//Arrange
		Fournisseur f = new Fournisseur("nom","prenom",new Adresse("numero","voie","ville","cp"),"societe");
		f = (Fournisseur) daoPersonne.save(f);
		Produit p = new Produit("libelle",50,f);
		p = daoProduit.save(p);	
		//Act
		Produit copieBdd  = daoProduit.findById(p.getId());
		
		//Assert
		assertNotNull(copieBdd);
		assertEquals(p, copieBdd);
	}
	
	@Test
	public void testDelete() 
	{
		//Arrange
		Fournisseur f = new Fournisseur("nom","prenom",new Adresse("numero","voie","ville","cp"),"societe");
		f = (Fournisseur) daoPersonne.save(f);
		Produit p = new Produit("libelle",50,f);
		p = daoProduit.save(p);	
		//Act
		daoProduit.delete(p);
		Produit copieBdd  = daoProduit.findById(p.getId());
		//Assert
		//assertNull(copieBdd);	
		if(copieBdd!=null) 
		{
			fail();
		}
	}
}

