package quest.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.model.Stagiaire;

public class Test {

	@Autowired
	private IDAOFiliere daoFiliere;

	public void run(String[] ...args) {

		Filiere f = daoFiliere.findByIdWithEleves(2);
		System.out.println("Infos sur la filiere : "+f);
		System.out.println("Liste de ses stagiaires : ");
		
		for(Stagiaire s : f.getEleves()) 
		{
			System.out.println(s);
		}
		
		
		System.out.println(daoFiliere.findByDebutBetween(LocalDate.parse("2022-10-24"), LocalDate.parse("2022-10-27")));
		
	}
}
