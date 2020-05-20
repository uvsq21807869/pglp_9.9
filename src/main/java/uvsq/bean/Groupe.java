package uvsq.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Groupe extends Graphic {

	private List<Graphic> liste;

	/**
	 * Ensemble de graphics (formes et groupes).
	 * 
	 * @param nom Nom du groupe
	 */
	public Groupe(String nom) {

		super(nom);
		liste = new ArrayList<>();
	}

	/**
	 * Affiche les composants de groupe.
	 */
	public void afficher() {
		System.out.println("Groupe " + this.nom + ": ");
		for (Graphic graphic : this.liste) {
			System.out.print("\t");
			graphic.afficher();
		}
	}

	public List<Graphic> getListeNonModifiable() {

		return Collections.unmodifiableList(this.liste);
	}

	public void ajoutForme(Graphic graphic) {
		this.liste.add(graphic);
	}

	/**
	 * Déplace l'ensemble des composants de groupe.
	 * 
	 * @param x Abscisse
	 * @param y Ordonnée
	 */
	public void deplacerDirection(int x, int y) {
		for (Graphic graphic : this.liste) {
			graphic.deplacerDirection(x, y);
		}
	}

}
