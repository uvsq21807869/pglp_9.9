package uvsq.commande;

import uvsq.bean.*;

public abstract class CreationFormeCommand implements Command {

	protected Dessin dessin;

	/**
	 * Commande de création de forme.
	 *
	 * @param dessin Dessin en cours
	 */
	public CreationFormeCommand(Dessin dessin) {
		this.dessin = dessin;
	}

	/**
	 * Vérifie si la forme existe.
	 *
	 * @param nom Nom de la forme à vérifier
	 * @return vraie ou faux
	 */
	public boolean exist(String nom) {

		for (Graphic elem : dessin.getGraphicsList()) {

			if (elem.getNom().matches(nom)) {
				return true;
			}
		}

		return false;
	}
}
