package quest.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import quest.config.AppConfig;
import quest.model.Filiere;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class }) 
@Transactional 
@Rollback(true) 
public class DAOFiliereTest {

	@Autowired
	private IDAOFiliere daoFiliere;



	@Test
	public void initDaoFiliere() 
	{
		if(daoFiliere==null) 
		{
			fail();
		}
	}


	@Test
	public void insertFiliere() 
	{
		LocalDate debut = LocalDate.now();
		LocalDate fin = debut.plusDays(52);
		Filiere filiere = new Filiere("libelle",debut,fin);	

		filiere = daoFiliere.save(filiere);
		Optional<Filiere> opt = daoFiliere.findById(filiere.getId());
		
		Filiere filiereBdd = opt.get();

		assertNotNull(filiereBdd);
		assertNotNull(filiereBdd.getId());
		assertEquals(debut, filiereBdd.getDebut());
		assertEquals(fin, filiereBdd.getFin());
		assertEquals("libelle", filiereBdd.getLibelle());

	}

}	

