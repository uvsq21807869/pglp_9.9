package uvsq.dao;

import java.sql.Connection;
import java.sql.Statement;

import uvsq.connection.DBConnection;

public abstract class Dao<T> {

	protected Connection connect = null;

	public Statement stmt = null;

	public abstract boolean create(T obj);

	public abstract T find(String id);

	public abstract boolean delete(String id);

	public static String nom = "default";

	public void connect() {
		this.connect = DBConnection.getInstance();
	}

}
