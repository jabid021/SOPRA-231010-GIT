package poudlard.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Animal;
import poudlard.model.Eleve;
import poudlard.model.Equipe;
import poudlard.model.Joueur;
import poudlard.model.Maison;
import poudlard.model.Match;
import poudlard.model.Poste;
import poudlard.model.Professeur;

public class Test {

	public static void main(String[] args) {
		
		Professeur prof1 = new Professeur ("McgMin","1234miaou","Mcgonagall","Minerva");
		Professeur prof2 = new Professeur ("SevRog","1234pot","Rogue","Severus");
		Professeur prof3 = new Professeur ("SevRog","1234pot","Rogue","Severus");
		Professeur prof4 = new Professeur ("SevRog","1234pot","Rogue","Severus");

		
		Maison gryffondor = new Maison("gryffondor" , 100 , prof1) ;

		Maison serpentard = new Maison("serpentard" , 20 , prof2) ;

		Maison serdaigle = new Maison("serdaigle" , 50 , prof3) ;

		Maison poufsouffle = new Maison("poufsouffle" , 50 , prof4) ;

		Equipe equipe1 = new Equipe("lion" , gryffondor ) ; 

		Equipe equipe2 = new Equipe("cobra" , serpentard ) ; 

		Equipe equipe3 = new Equipe("aigle" , serdaigle ) ; 

		Equipe equipe4 = new Equipe("blaireau" ,poufsouffle ) ; 

		Animal animal1 = new Animal("Jordan","canard");
		Animal animal2 = new Animal("Edwige","chouette");
		Animal animal3 = new Animal("Croutard","rat");
		Animal animal4 = new Animal("Patmol","chien");
		Animal animal5 = new Animal("Pattenrond","chat");

		Eleve eleve1 = new Eleve("PotHar","1234Edwige","Potter","Harry",1,animal1,gryffondor);
		Eleve eleve2 = new Eleve("GraHer","1234Patten","Granger","Hermione",4,animal5,gryffondor);
		Eleve eleve3 = new Eleve("WeaRon","1234Crout","Weasley","Ron",2,animal3,gryffondor);
		

		Joueur joueur1 = new Joueur(LocalDate.parse("2020-10-10"), eleve1, equipe1, Poste.Attrapeur);
		Joueur joueur2 = new Joueur(true, LocalDate.now(), eleve2, equipe2, Poste.Poursuiveur);
		
		Match match1 = new Match(LocalDate.parse("2020-12-31"), LocalTime.parse("20:45:00"), equipe1, equipe2 ); 
		Match match2 = new Match(LocalDate.now(), LocalTime.now(), equipe3, equipe4 ); 
	

		
	}

}
