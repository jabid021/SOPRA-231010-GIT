package entreprise.test;

import java.time.LocalDate;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class Test {

	public static void main(String[] args) {
		
		//en dev, les types basiques => int,double,boolean,short,long => primitives
		//surcouches => Wrappers => int => Integer , double => Double, boolean => Boolean, short => Short, long => Long
		Departement d10 = new Departement(10, "Accounting", "New York");
		Departement d20 = new Departement(20, "Research", "Dallas");
		Departement d30 = new Departement(30, "Sales", "Chicago");

		/*
		String prenom = null;
		//Integer a une fonction permettant de transformer un "String" vers un int
		Integer comm = Integer.parseInt("1");
		comm++;
		
		System.out.println(comm);
		
		Double salaire = null;
		Boolean test = null;
		*/
		

		
		Employe king = new Employe(7839, "King", "President", null, LocalDate.parse("2016-05-01"), 5000, null, d10);
		
		Employe blake = new Employe(7698, "Blake", "Manager", king, LocalDate.parse("2017-09-20"), 2850, null, d30);
		
		Employe alen = new Employe(7499, "Allen", "Salesman", blake, LocalDate.parse("2018-06-13"), 1600, 300, d30); 
		
		Employe turner = new Employe(7844, "Turner", "Salesman", blake, LocalDate.parse("2018-06-23"), 1500, 0, d30);
		
		
		
		
	}

}
