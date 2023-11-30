package orchestre.model;

public class Guitariste implements IMusicien {

	private String prenom;
	private IInstrument instrument;
	
	
	@Override
	public void jouer() {
		System.out.println("Le guitariste "+prenom+" joue ! "+instrument.son());
		
	}

}
