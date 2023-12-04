package quest.demoJunit;

public class Voiture {

	private Integer vitesse;
	private boolean marche;
	
	public Voiture() {
	}
	
	public Voiture(Integer vitesse, boolean marche) {
		this.vitesse = vitesse;
		this.marche = marche;
	}
	
	public Integer getVitesse() {
		return vitesse;
	}
	public void setVitesse(Integer vitesse) {
		this.vitesse = vitesse;
	}
	public boolean isMarche() {
		return marche;
	}
	public void setMarche(boolean marche) {
		this.marche = marche;
	}
	
	
	public void start(Integer vitesse) 
	{
		if(vitesse>0)
		{
			this.vitesse=vitesse;
			this.marche=true;
		}
	
	}
	
	public void stop() 
	{
		this.vitesse=0;
		this.marche=false;
	}
	
}
