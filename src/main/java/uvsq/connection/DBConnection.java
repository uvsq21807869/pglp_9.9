package uvsq.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * la classe effectue la connexion de la base de données afin d'effectuer les
 * manipulations utilisation du pattern singleton qui nous permet d'assurer la
 * connection une seule fois
 */
public class DBConnection {

	static final private String JDBC_DRIVER = "org.h2.Driver";
	static final private String DB_URL = "jdbc:h2:./database";

	// Objet Connection
	private static Connection connection;

	// Constructeur prive
	private DBConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Methode qui va nous retourner notre instance et la creer si elle n'existe pas
	public static Connection getInstance() {
		if (connection == null) {
			new DBConnection();
		}
		return connection;
	}

	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
