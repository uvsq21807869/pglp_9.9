package uvsq.commande;

import uvsq.bean.*;

public class DeplacerGroupeCommand implements Command {

	private Groupe groupe;
	private int abscisse;
	private int ordonne;

	/**
	 * Commande qui gere le deplacement d'un group de forme a une position donnee.
	 *
	 * @param groupe Groupe à déplacer
	 * @param x      Distance verticale
	 * @param y      Distance horizontale
	 */
	public DeplacerGroupeCommand(Groupe groupe, int x, int y) {
		this.groupe = groupe;
		this.abscisse = x;
		this.ordonne = y;
	}

	/** Déplace le groupe. */
	@Override
	public void execute() {

		this.groupe.deplacerDirection(abscisse, ordonne);
	}
}
