package uvsq.bean;

public class Triangle extends Forme {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	/**
	 * Forme du triangle.
	 * 
	 * @param nom Nom du triangle
	 * @param a   PointA
	 * @param b   PointB
	 * @param c   PointC
	 */

	public Triangle(String nom, Point pointA, Point pointB, Point pointC) {
		super(nom);
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	@Override
	public void afficher() {
		System.out.println(this.nom + "(A=" + this.getPointA().getPosition() + ", B=" + this.getPointB().getPosition()
				+ ", C=" + this.getPointC().getPosition() + ")");
	}

	/**
	 * déplacer les trois points du triangle.
	 * 
	 * @param x Abscisse
	 * @param y Ordonnée
	 */
	public void move(int x, int y) {
		int tmpX = this.getPointA().getX();
		int tmpY = this.getPointA().getY();
		this.getPointA().move(x, y);
		this.getPointB().move(this.getPointB().getX() + (this.getPointA().getX() - tmpX),
				this.getPointB().getY() + (this.getPointA().getX() - tmpY));
		this.getPointC().move(this.getPointC().getX() + (this.getPointA().getX() - tmpX),
				this.getPointC().getY() + (this.getPointA().getX() - tmpY));
	}

	public Point getPointC() {
		return pointC;
	}

	public Point getPointA() {
		return pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	@Override
	public void deplacerDirection(int x, int y) {
		this.move(this.getPointA().getX() + x, this.getPointA().getY() + y);
	}

}
