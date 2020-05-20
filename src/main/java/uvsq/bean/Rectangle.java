package uvsq.bean;

public class Rectangle extends Forme {

	private Point pointDOrigine;
	private int longueur;
	private int hauteur;

	/**
	 * Forme du rectangle.
	 * 
	 * @param nom           Nom du rectangle
	 * @param pointDOrigine Point d'origine
	 * @param longueur      Longueur
	 * @param hauteur       Hauteur
	 */
	public Rectangle(String nom, Point pointDOrigine, int longueur, int hauteur) {
		super(nom);
		this.pointDOrigine = pointDOrigine;
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void move(int x, int y) {
		this.getPointDOrigine().move(x, y);
	}

	@Override
	public void afficher() {
		System.out.println(this.nom + " (Le point d'origine =" + getPointDOrigine().getPosition() + ", longeur = "
				+ this.getLongueur() + ", hauteur =" + this.getHauteur() + ")");
	}

	@Override
	public void deplacerDirection(int x, int y) {
		this.getPointDOrigine().move(this.getPointDOrigine().getX() + x, this.getPointDOrigine().getY() + y);
	}

	public int getLongueur() {
		return longueur;
	}

	public Point getPointDOrigine() {
		return pointDOrigine;
	}
}
