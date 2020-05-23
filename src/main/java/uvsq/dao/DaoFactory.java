package uvsq.dao;

import uvsq.bean.*;
import uvsq.implement.*;

public class DaoFactory {

	/**
	 * Retourne un objet Dessin interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Dessin> getDessinDao() {
		return new DessinDao();
	}

	/**
	 * Retourne un objet Groupe interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Groupe> getGroupeDao() {
		return new GroupeDao();
	}

	/**
	 * Retourne un objet Carre interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Carre> getCarreDao() {
		return new CarreDao();
	}

	/**
	 * Retourne un objet Cercle interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Cercle> getCercleDao() {
		return new CercleDao();
	}

	/**
	 * Retourne un objet Rectangle interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Rectangle> getRectangleDao() {
		return new RectangleDao();
	}

	/**
	 * Retourne un objet Triangle interagissant avec la BDD
	 * 
	 * @return DAO
	 */
	public static Dao<Triangle> getTriangleDao() {
		return new TriangleDao();
	}
}
