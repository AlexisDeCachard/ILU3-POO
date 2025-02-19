package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = {new Configuration(new Borne(25), 10), new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10), new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4), new Configuration(new Parade(Type.FEU), 14), new Configuration(new FinLimite(), 6), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5), new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3), new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3), new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1), new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1)};
	private int nbCartes= 106;
	
	public String affichageJeuDeCartes() {
		StringBuilder chaine = new StringBuilder();
		for (int i = 0; i < typesDeCartes.length; i++) {
			Configuration actu = typesDeCartes[i];
			String ligne=actu.getNbExemplaire() + " " + actu.getCarte().toString() + "\n";
			chaine.append(ligne);
		}
		return chaine.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] cartes=new Carte[nbCartes];
		int j=0;
		for (Configuration config : typesDeCartes) {
			for (int i = 0; i < config.getNbExemplaire(); i++) {
				cartes[j+i]=config.getCarte();
			}
			j+=config.getNbExemplaire();
		}
		return cartes;
		
	}
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		int totalCartes= cartes.length;
		return nbCartes == totalCartes;
	}
}
