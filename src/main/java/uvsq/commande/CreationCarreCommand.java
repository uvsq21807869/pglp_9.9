package uvsq.commande;

import uvsq.bean.*;

public class CreationCarreCommand extends CreationFormeCommand {

	private String nom;
	private Point cpoint;
	private int cote;

	/**
	 * Commande de création de carrée.
	 *
	 * @param nom    Nom du carrée
	 * @param point      Point en bas à droite
	 * @param cote   Longueur d'u côté
	 * @param dessin Dessin principal
	 */
	public CreationCarreCommand(String nom, Point point, int cote, Dessin dessin) {

		super(dessin);
		this.nom = nom;
		this.cpoint = point;
		this.cote = cote;
	}

	/** Ajout de carré au dessin. */
	@Override
	public void execute() {
		if (!this.exist(this.nom)) {
			super.dessin.addGraphic(new Carre(nom, cpoint, cote));
		}
	}
}
