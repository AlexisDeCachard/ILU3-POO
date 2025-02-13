package cartes;

public class Configuration {
	private Carte carte;
	private int nbExemplaire;
	
	public Configuration(Carte carte, int nbExemplaire) {
		this.carte = carte;
		this.nbExemplaire = nbExemplaire;
	}

	public Carte getCarte() {
		return carte;
	}

	public int getNbExemplaire() {
		return nbExemplaire;
	}

}
