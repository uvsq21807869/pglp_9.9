package uvsq.bean;

public abstract class Graphic {

	protected final String nom;

	public Graphic(String nom) {
		this.nom = nom;
	}

	public abstract void afficher();

	/**
	 * Déplace la forme avec un vecteur deplacement.
	 *
	 * @param x Abscisse
	 * @param y Ordonnée
	 */
	public abstract void deplacerDirection(int x, int y);

	public String getNom() {
		return nom;
	}
}
