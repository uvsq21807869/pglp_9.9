package uvsq.dao;

import java.sql.Connection;
import java.sql.Statement;

import uvsq.connection.DBConnection;

public abstract class Dao<T> {

	public static String nom = "default";
	public Statement stmt = null;

	protected Connection connect = null;

	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(String id);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(String id);

	public Dao() {
		this.connect = DBConnection.getInstance();
	}

}