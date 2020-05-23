package uvsq.connection;

import java.sql.SQLException;
import java.sql.Statement;

public final  class Database {

	/**
	 * classe immuable  qui nous permet de creer la base de données .
	 */
	public Database() {
	}

	public boolean creatDatabase() {
		Statement stmt = null;
		try {

			stmt = DBConnection.getInstance().createStatement();
			String createTable = "CREATE TABLE  IF NOT EXISTS Dessin(nomDessin varchar(50) PRIMARY KEY NOT NULL)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS Groupe (nomGroup varchar(50) PRIMARY KEY NOT NULL)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS Carre( nom varchar(50) PRIMARY KEY NOT NULL, x int, y int, cote int)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS Cercle( nom varchar(50) PRIMARY KEY NOT NULL, x int, y int, rayon int)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS Rectangle( nom varchar(50) PRIMARY KEY NOT NULL, x int,"
					+ " y int, longueur int, hauteur int)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS Triangle( nom varchar(50) PRIMARY KEY NOT NULL, ax int,"
					+ " ay int, bx int, by int, cx int, cy int)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS CarreGroupe(nomGroup varchar(50), nom varchar(50), PRIMARY KEY(nomGroup,nom), "
					+ "FOREIGN KEY (nomGroup) REFERENCES Groupe(nomGroup) ON DELETE CASCADE, "
					+ "FOREIGN KEY (nom) REFERENCES Carre(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS CercleGroupe(nomGroup varchar(50), nom varchar(50), PRIMARY KEY(nomGroup,nom),"
					+ " FOREIGN KEY (nomGroup) REFERENCES Groupe(nomGroup) ON DELETE CASCADE,"
					+ " FOREIGN KEY (nom) REFERENCES Cercle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS RectangleGroupe(nomGroup varchar(50), nom varchar(50), PRIMARY KEY(nomGroup,nom),"
					+ " FOREIGN KEY (nomGroup) REFERENCES Groupe(nomGroup) ON DELETE CASCADE,"
					+ " FOREIGN KEY (nom) REFERENCES Rectangle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS TriangleGroupe(nomGroup varchar(50), nom varchar(50), PRIMARY KEY(nomGroup,nom),"
					+ " FOREIGN KEY (nomGroup) REFERENCES Groupe(nomGroup) ON DELETE CASCADE,"
					+ " FOREIGN KEY (nom) REFERENCES Triangle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS GroupeGroupe(nomGroup varchar(50), nom varchar(50), PRIMARY KEY(nomGroup,nom)"
					+ ", FOREIGN KEY (nomGroup) REFERENCES Groupe(nomGroup) ON DELETE CASCADE, "
					+ "FOREIGN KEY (nom) REFERENCES Groupe(nomGroup) ON DELETE CASCADE)";
			stmt.execute(createTable);
			/////////////////////////////////////////////////////////////////////////////

			createTable = "CREATE TABLE  IF NOT EXISTS CarreDessin(nomDessin varchar(50), nom varchar(50), PRIMARY KEY(nomDessin,nom),"
					+ " FOREIGN KEY (nomDessin) REFERENCES Dessin(nomDessin) ON DELETE CASCADE, "
					+ "FOREIGN KEY (nom) REFERENCES Carre(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS CercleDessin(nomDessin varchar(50), nom varchar(50), PRIMARY KEY(nomDessin,nom), "
					+ "FOREIGN KEY (nomDessin) REFERENCES Dessin(nomDessin) ON DELETE CASCADE, "
					+ "FOREIGN KEY (nom) REFERENCES Cercle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS RectangleDessin(nomDessin varchar(50), nom varchar(50), PRIMARY KEY(nomDessin,nom), "
					+ "Constraint FK_RDD FOREIGN KEY (nomDessin) REFERENCES Dessin(nomDessin) ON DELETE CASCADE , "
					+ "Constraint FK_RDN FOREIGN KEY (nom) REFERENCES Rectangle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS TriangleDessin(nomDessin varchar(50), nom varchar(50), PRIMARY KEY(nomDessin,nom), "
					+ "FOREIGN KEY (nomDessin) REFERENCES Dessin(nomDessin) ON DELETE CASCADE,"
					+ " FOREIGN KEY (nom) REFERENCES Triangle(nom) ON DELETE CASCADE)";
			stmt.execute(createTable);
			createTable = "CREATE TABLE  IF NOT EXISTS  GroupeDessin(nomDessin varchar(50), nom varchar(50), PRIMARY KEY(nomDessin,nom),"
					+ " FOREIGN KEY (nomDessin) REFERENCES Dessin(nomDessin) ON DELETE CASCADE, "
					+ "FOREIGN KEY (nom) REFERENCES Groupe(nomGroup) ON DELETE CASCADE)";
			stmt.execute(createTable);
			return true;
		} catch (SQLException e) {

			try {
				DBConnection.getInstance().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}
}