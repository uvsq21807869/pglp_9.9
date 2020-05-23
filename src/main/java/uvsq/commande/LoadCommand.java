package uvsq.commande;

import uvsq.dao.DaoFactory;

public class LoadCommand implements Command {

	private String nom;
	private DrawingTui draw;

	/**
	 * Commande consiste a charger le dessin a partir de notre bd
	 *
	 * @param nom  Nom du dessin
	 * @param draw Interface utilisateur
	 */
	public LoadCommand(String nom, DrawingTui draw) {
		this.nom = nom;
		this.draw = draw;
	}

	/**la recherche et la recupération du dessin . */
	@Override
	public void execute() {
		
		this.draw.setDessin(DaoFactory.getDessinDao().find(this.nom));
	}
}
