package uvsq.commande;

import java.util.List;
import uvsq.bean.*;

public class SupprimerGraphicCommand implements Command {

	private String asupprimer;
	private Dessin dessin;

	/**
	 * Supprime un graphic du dessin.
	 *
	 * @param dessin     Dessin en cours
	 * @param asupprimer Nom du graphic à supprimer
	 */
	public SupprimerGraphicCommand(Dessin dessin, String asupprimer) {
		this.dessin = dessin;
		this.asupprimer = asupprimer;
	}

	/** Supprime graphic. */
	@Override
	public void execute() {
		List<Graphic> liste = this.dessin.getListe();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getNom().matches(asupprimer)) {
				liste.remove(i);
			}
		}
	}
}
