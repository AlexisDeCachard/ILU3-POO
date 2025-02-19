package tests;

import cartes.*;
import jeu.*;

public class TestSabot {
	
	public static void main(String[] args) {
		Attaque accident = new Attaque(Type.ACCIDENT);
		Parade reparation = new Parade(Type.ACCIDENT);
		Botte asDuVolant = new Botte(Type.ACCIDENT);
		Sabot sabot = new Sabot();
		sabot.ajouterCarte(accident);
		sabot.ajouterCarte(reparation);
		sabot.ajouterCarte(asDuVolant);
		
		for (int i = 0; i < 7; i++) {
			System.out.println("je pioche " + sabot.piocher().toString() + "\n");
		}
			
	}
}
