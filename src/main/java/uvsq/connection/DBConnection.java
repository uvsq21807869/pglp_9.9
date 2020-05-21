package uvsq.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static final private String JDBC_DRIVER = "org.h2.Driver";
	static final private String DB_URL = "jdbc:h2:./database";

	// Objet Connection
	private static Connection connection;

	// Constructeur privé
	private DBConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static Connection getInstance() {
		if (connection == null) {
			new DBConnection();
		}
		return connection;
	}
}
