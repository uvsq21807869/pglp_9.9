package uvsq.commande;

import uvsq.bean.*;

public class CreationTriangleCommand extends CreationFormeCommand {

	private String nom;
	private Point pointa;
	private Point pointb;
	private Point pointc;

	/**
	 * Commande de création de triangle.
	 *
	 * @param nom    Nom du triangle
	 * @param pointa      Position du point a
	 * @param pointb      Position du point b
	 * @param pointc      Position du point c
	 * @param dessin Dessin à envoyer
	 */
	public CreationTriangleCommand(String nom, Point pointa, Point pointb, Point pointc, Dessin dessin) {
		super(dessin);
		this.nom = nom;
		this.pointa = pointa;
		this.pointb = pointb;
		this.pointc = pointc;
	}

	/** Ajoute le triangle au dessin. */
	@Override
	public void execute() {
		if (!this.exist(this.nom)) {
			super.dessin.addGraphic(new Triangle(nom, pointa, pointb, pointc));
		}
	}
}
