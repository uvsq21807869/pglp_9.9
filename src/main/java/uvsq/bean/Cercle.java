package uvsq.bean;

public class Cercle extends Forme {

	private Point centre;
	private int rayon;

	/**
	 * Forme du cercle.
	 * 
	 * @param nom    Nom du cercle
	 * @param centre Point du centre
	 * @param rayon  Rayon du cercle
	 */
	public Cercle(String nom, Point centre, int rayon) {
		super(nom);
		this.rayon = rayon;
		this.centre = centre;
	}

	public void move(int x, int y) {
		this.getCentre().move(x, y);
	}

	public Point getCentre() {
		return centre;
	}

	@Override
	public void afficher() {
		System.out.println(this.nom + "(centre=" + this.getCentre().getPosition() + ",rayon=" + this.getRayon() + ")");
	}

	public int getRayon() {
		return rayon;
	}

	@Override
	public void deplacerDirection(int x, int y) {
		this.move(this.getCentre().getX() + x, this.getCentre().getY() + y);
	}

}
