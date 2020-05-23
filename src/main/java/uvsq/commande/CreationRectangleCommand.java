package uvsq.commande;

import uvsq.bean.*;

public class CreationRectangleCommand extends CreationFormeCommand {

	private Point point;
	private int longueur;
	private int hauteur;
	private String nom;

	/**
	 * Commande de création de rectangle.
	 *
	 * @param nom      Nom du rectangle
	 * @param point        Point en bas à gauche
	 * @param longueur Longueur
	 * @param hauteur  Hauteur
	 * @param dessin   Dessin en cours
	 */
	public CreationRectangleCommand(String nom, Point point, int longueur, int hauteur, Dessin dessin) {
		super(dessin);
		this.point = point;
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.nom = nom;
	}

	/** Ajoute le rectangle au dessin. */
	@Override
	public void execute() {
		if (!this.exist(this.nom)) {
			super.dessin.addGraphic(new Rectangle(nom, point, longueur, hauteur));
		}
	}
}
