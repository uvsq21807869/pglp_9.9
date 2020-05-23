package uvsq.commande;

import uvsq.bean.*;

public class DeplacerCommand implements Command {

	private Forme forme;
	private int abscisse;
	private int ordonne;

	/**
	 * Commande qui gere le deplacement d'une forme a une position donnee.
	 *
	 * @param forme Forme à déplacer
	 * @param x     abscicsse
	 * @param y     ordonnée
	 */
	public DeplacerCommand(Forme forme, int x, int y) {
		this.forme = forme;
		this.abscisse = x;
		this.ordonne = y;
	}

	/** Déplace la forme. */
	@Override
	public void execute() {

		this.forme.move(abscisse, ordonne);
	}
}
