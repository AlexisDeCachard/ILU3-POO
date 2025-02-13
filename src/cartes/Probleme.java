package cartes;

public abstract class Probleme extends Carte {
	private Type type;

	protected Probleme(Type type) {
		super();
		this.type=type;
	}
	
	public Type getType() {
		return type;
	}
	
	public String toString(String soustype) {
		switch(soustype) {
			case "A" :
				return type.getAttaque();
			case "P" :
				return type.getParade();
			case "B" :
				return type.getBotte();
			default :
				return "Oupsi doupsi petit bug";
		}	
	}

}
