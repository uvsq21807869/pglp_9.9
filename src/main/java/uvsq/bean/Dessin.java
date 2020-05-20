package uvsq.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dessin {

	private List<Graphic> graphics;
	private String nom;

	/**
	 * Groupe principal et sauvegardable.
	 * 
	 * @param nom Nom du dessin
	 */
	public Dessin(String nom) {

		this.nom = nom;
		this.graphics = new ArrayList<>();
	}

	public List<Graphic> getGraphicsList() {
		return Collections.unmodifiableList(graphics);
	}

	public String getNom() {
		return new String(this.nom);
	}

	/**
	 * Vérfie si la forme à ajouter existe ou pas .
	 * 
	 * @param nom Le nom de la forme à vérifier
	 * @return true or false
	 */
	public boolean exists(String nom) {
		for (int i = 0; i < this.graphics.size(); i++) {
			if (this.graphics.get(i).getNom().matches(nom)) {
				return true;
			}
		}
		return false;
	}

	public void setGraphicsList(List<Graphic> list) {
		this.graphics = list;
	}

	public void addGraphic(Graphic graphic) {
		this.graphics.add(graphic);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Graphic> getListe() {
		return this.graphics;
	}
}
