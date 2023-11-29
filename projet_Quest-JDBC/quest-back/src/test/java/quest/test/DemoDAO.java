package quest.test;

import java.time.LocalDate;
import java.util.List;

import quest.context.Singleton;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.model.Filiere;
import quest.model.Matiere;

public class DemoDAO {




	static IDAOMatiere daoMatiere = Singleton.getInstance().getDaoMatiere();
	static IDAOFiliere daoFiliere = Singleton.getInstance().getDaoFiliere();

	public static void main(String[] args) {

		daoMatiere.deleteById(3);
		System.out.println(daoMatiere.findAll());

		Matiere m1 = daoMatiere.findById(1);

		m1.setLibelle("Nouveau nom");


		

		List<Filiere> filieres = daoFiliere.findByDebutBetween(LocalDate.parse("2022-10-26"), LocalDate.parse("2022-10-27"));	
		for(Filiere f : filieres) 
		{
			System.out.println(f);
		}
		
		
		Singleton.getInstance().getEmf().close();
	}

}
