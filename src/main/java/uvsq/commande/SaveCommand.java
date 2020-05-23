package uvsq.commande;

import uvsq.bean.*;
import uvsq.dao.*;

public class SaveCommand implements Command {

	private Dessin dessin;

	/**
	 * Commande consiste a enregistrer le dessin courant dans la bd.
	 *
	 * @param dessin Dessin
	 */
	public SaveCommand(Dessin dessin) {
		this.dessin = dessin;
	}

	/** ajouter le dessin dans la base de donnee */ 
	public void execute() {
		DaoFactory.getDessinDao().create(this.dessin);
	}
}
