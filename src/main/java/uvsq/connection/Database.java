package uvsq.connection;


import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	  /**
	   * Application qui lance le système de dessin et crée la base de données si besoin.
	   */
	  public Database() {}
	  public boolean creatDatabase(){
		   Statement stmt = null;
		    try {

		    	stmt=DBConnection.getInstance().createStatement();
			      String createTable = "CREATE TABLE  IF NOT EXISTS Dessin(dnom varchar(50) PRIMARY KEY NOT NULL)";
			      stmt.execute(createTable);
			      createTable = "CREATE TABLE  IF NOT EXISTS Groupe (gnom varchar(50) PRIMARY KEY NOT NULL)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS Carre( nom varchar(50) PRIMARY KEY NOT NULL, x int, y int, cote int)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS Cercle( nom varchar(50) PRIMARY KEY NOT NULL, x int, y int, rayon int)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS Rectangle( nom varchar(50) PRIMARY KEY NOT NULL, x int,"
			              + " y int, longueur int, hauteur int)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS Triangle( nom varchar(50) PRIMARY KEY NOT NULL, ax int,"
			              + " ay int, bx int, by int, cx int, cy int)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS CarreGroupe(gnom varchar(50), nom varchar(50), PRIMARY KEY(gnom,nom), "
			              + "FOREIGN KEY (gnom) REFERENCES Groupe(gnom) ON DELETE CASCADE, "
			              + "FOREIGN KEY (nom) REFERENCES Carre(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS CercleGroupe(gnom varchar(50), nom varchar(50), PRIMARY KEY(gnom,nom),"
			              + " FOREIGN KEY (gnom) REFERENCES Groupe(gnom) ON DELETE CASCADE,"
			              + " FOREIGN KEY (nom) REFERENCES Cercle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS RectangleGroupe(gnom varchar(50), nom varchar(50), PRIMARY KEY(gnom,nom),"
			              + " FOREIGN KEY (gnom) REFERENCES Groupe(gnom) ON DELETE CASCADE,"
			              + " FOREIGN KEY (nom) REFERENCES Rectangle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS TriangleGroupe(gnom varchar(50), nom varchar(50), PRIMARY KEY(gnom,nom),"
			              + " FOREIGN KEY (gnom) REFERENCES Groupe(gnom) ON DELETE CASCADE,"
			              + " FOREIGN KEY (nom) REFERENCES Triangle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS GroupeGroupe(gnom varchar(50), nom varchar(50), PRIMARY KEY(gnom,nom)"
			              + ", FOREIGN KEY (gnom) REFERENCES Groupe(gnom) ON DELETE CASCADE, "
			              + "FOREIGN KEY (nom) REFERENCES Groupe(gnom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      /////////////////////////////////////////////////////////////////////////////

			      createTable =
			          "CREATE TABLE  IF NOT EXISTS CarreDessin(dnom varchar(50), nom varchar(50), PRIMARY KEY(dnom,nom),"
			              + " FOREIGN KEY (dnom) REFERENCES Dessin(dnom) ON DELETE CASCADE, "
			              + "FOREIGN KEY (nom) REFERENCES Carre(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS CercleDessin(dnom varchar(50), nom varchar(50), PRIMARY KEY(dnom,nom), "
			              + "FOREIGN KEY (dnom) REFERENCES Dessin(dnom) ON DELETE CASCADE, "
			              + "FOREIGN KEY (nom) REFERENCES Cercle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS RectangleDessin(dnom varchar(50), nom varchar(50), PRIMARY KEY(dnom,nom), "
			              + "Constraint FK_RDD FOREIGN KEY (dnom) REFERENCES Dessin(dnom) ON DELETE CASCADE , "
			              + "Constraint FK_RDN FOREIGN KEY (nom) REFERENCES Rectangle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS TriangleDessin(dnom varchar(50), nom varchar(50), PRIMARY KEY(dnom,nom), "
			              + "FOREIGN KEY (dnom) REFERENCES Dessin(dnom) ON DELETE CASCADE,"
			              + " FOREIGN KEY (nom) REFERENCES Triangle(nom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      createTable =
			          "CREATE TABLE  IF NOT EXISTS  GroupeDessin(dnom varchar(50), nom varchar(50), PRIMARY KEY(dnom,nom),"
			              + " FOREIGN KEY (dnom) REFERENCES Dessin(dnom) ON DELETE CASCADE, "
			              + "FOREIGN KEY (nom) REFERENCES Groupe(gnom) ON DELETE CASCADE)";
			      stmt.execute(createTable);
			      return true;
		    } catch ( SQLException e) {
		     
		    	try {
					DBConnection.getInstance().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		    	return false;
		    }
}
}