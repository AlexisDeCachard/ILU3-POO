package cartes;

public enum Type {
	FEU("Feu Vert","Feu Rouge","V�hicule Prioritaire"), ESSENCE("Bidon d'essence","Panne d'essence", "Citerne"), 
	CREVAISON("Roue de secours", "Crevaison", "Increvable"), ACCIDENT("R�parations", "Accident", "As du volant");
	
	private String parade;
	private String attaque;
	private String botte;
	
	private Type(String parade, String attaque, String botte) {
		this.parade = parade;
		this.attaque = attaque;
		this.botte = botte;
	}
	public String getParade() {
		return parade;
	}
	public String getAttaque() {
		return attaque;
	}
	public String getBotte() {
		return botte;
	}
	
	
}
