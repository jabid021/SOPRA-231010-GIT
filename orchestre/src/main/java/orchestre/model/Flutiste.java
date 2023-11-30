package orchestre.model;

public class Flutiste implements IMusicien {

	private String prenom;
	private IInstrument flute;
	
	
	@Override
	public void jouer() {
		System.out.println("Le flutiste "+prenom+" joue ! "+flute.son());
		
	}

}
