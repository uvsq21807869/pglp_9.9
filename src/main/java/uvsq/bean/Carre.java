package uvsq.bean;

public class Carre extends Forme {

	private Point pointDOrigine;
	private int cote;

	/**
	 * Forme du carré.
	 * 
	 * @param nom  Nom du carré
	 * @param p    Point d'origine
	 * @param cote Longueur du côté
	 */
	public Carre(String nom, Point pointDOrigine, int cote) {
		super(nom);
		this.pointDOrigine = pointDOrigine;
		this.cote = cote;
	}

	public void move(int x, int y) {
		this.getPointDOrigine().move(x, y);
	}

	@Override
	public void afficher() {
		System.out.println(this.nom + "(Le point d'origine = " + this.getPointDOrigine().getPosition() + ", côté="
				+ this.getCote() + ")");
	}

	public Point getPointDOrigine() {
		return pointDOrigine;
	}

	@Override
	public void deplacerDirection(int x, int y) {
		this.move(this.getPointDOrigine().getX() + x, this.getPointDOrigine().getY() + y);
	}

	public int getCote() {
		return cote;
	}
}
