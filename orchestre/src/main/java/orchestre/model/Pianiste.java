package orchestre.model;

public class Pianiste implements IMusicien {

	private String prenom;
	private Piano instrument;
	
	public Pianiste() {
		this.prenom="Eric";
	}
	
	@Override
	public void jouer() {
		System.out.println("Le pianiste "+prenom+" joue ! "+instrument.son());
		
	}

}
