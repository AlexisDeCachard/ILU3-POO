package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

import cartes.*;

public class Sabot implements Iterable<Carte> {
	private int nbCartesMax = 106;
	private int nbCartes;
	private Carte[] tabCartes;
	private Iterator<Carte> iterator = iterator();
	
	public Sabot() {
		this.tabCartes = new Carte[nbCartesMax];
		this.nbCartes = 0;
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes == nbCartesMax) {
			throw new ArrayIndexOutOfBoundsException("Le sabot est plein");
		}
		tabCartes[nbCartes] = carte;
		nbCartes++;
	}
	
	public Carte piocher(){
		Carte res = iterator.next();
		iterator.remove();
		return res;
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private int nbOperations = 0;
		private int nbOperationsReference = 0;
		private boolean nextEffectue = false;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		@Override
		public Carte next() {
			if (hasNext()) {
				Carte res = tabCartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return res;
			} else {
				throw new NoSuchElementException("Il n y a plus de carte apres");
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException("Il n y a pas de carte a supprimer");
			} else {
				for (int i = indiceIterateur - 1; i < nbCartes; i++) {
					tabCartes[i] = tabCartes[i + 1];
				}
				nextEffectue = false;
				indiceIterateur--;
				nbCartes--;
				nbOperationsReference++; 
				nbOperations++;
			}
		}
		
		private void verificationConcurrence(){
			if (nbOperations != nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}

}
