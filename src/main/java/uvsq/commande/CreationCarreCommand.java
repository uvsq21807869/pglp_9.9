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
	 * @param c      Point en bas à droite
	 * @param cote   Longueur d'u côté
	 * @param dessin Dessin principal
	 */
	public CreationCarreCommand(String nom, Point c, int cote, Dessin dessin) {

		super(dessin);
		this.nom = nom;
		this.cpoint = c;
		this.cote = cote;
	}

	/** Ajoute le carré au dessin. */
	@Override
	public void execute() {
		if (!this.exist(this.nom)) {
			super.dessin.addGraphic(new Carre(nom, cpoint, cote));
		}
	}
}
