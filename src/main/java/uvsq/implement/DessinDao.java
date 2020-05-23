package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import uvsq.bean.*;
import uvsq.dao.*;

public class DessinDao extends Dao<Dessin> {

	@Override
	public boolean create(Dessin obj) {
		obj.setNom(Dao.nom);
		try (PreparedStatement dessinInsert = this.connect.prepareStatement("INSERT INTO Dessin(nomDessin) values(?)");
				PreparedStatement carreInsert = this.connect
						.prepareStatement("INSERT INTO CarreDessin(nomDessin, nom) VALUES(?, ?)");
				PreparedStatement cercleInsert = this.connect
						.prepareStatement("INSERT INTO CercleDessin(nomDessin, nom) VALUES(?, ?)");
				PreparedStatement triangleInsert = this.connect
						.prepareStatement("INSERT INTO TriangleDessin(nomDessin, nom) VALUES(?, ?)");
				PreparedStatement groupeDessinInsert = this.connect
						.prepareStatement("INSERT INTO GroupeDessin(nomDessin, nom) VALUES(?, ?)");
				PreparedStatement rectangleInsert = this.connect
						.prepareStatement("INSERT INTO RectangleDessin(nomDessin, nom) VALUES(?, ?)");) {
			dessinInsert.setString(1, obj.getNom());
			dessinInsert.executeUpdate();
			List<Graphic> listElem = obj.getGraphicsList();
			Dao tmp;

			for (Graphic elem : listElem) {
				if (elem instanceof Groupe) {
					tmp = new GroupeDao();
					tmp.create((Groupe) elem);
					groupeDessinInsert.setString(1, obj.getNom());
					groupeDessinInsert.setString(2, Dao.nom + ":" + elem.getNom());
					groupeDessinInsert.executeUpdate();
				} else if (elem instanceof Cercle) {
					tmp = new CercleDao();
					tmp.create((Cercle) elem);
					cercleInsert.setString(1, obj.getNom());
					cercleInsert.setString(2, Dao.nom + ":" + elem.getNom());
					cercleInsert.executeUpdate();
				} else if (elem instanceof Rectangle) {
					System.out.println("Insertion rectangle: " + elem.getNom());
					tmp = new RectangleDao();
					tmp.create((Rectangle) elem);
					rectangleInsert.setString(1, obj.getNom());
					rectangleInsert.setString(2, Dao.nom + ":" + elem.getNom());
					rectangleInsert.executeUpdate();
				} else if (elem instanceof Carre) {
					tmp = new CarreDao();
					tmp.create((Carre) elem);
					carreInsert.setString(1, obj.getNom());
					carreInsert.setString(2, Dao.nom + ":" + elem.getNom());
					carreInsert.executeUpdate();
				} else if (elem instanceof Triangle) {
					tmp = new TriangleDao();
					tmp.create((Triangle) elem);
					triangleInsert.setString(1, obj.getNom());
					triangleInsert.setString(2, Dao.nom + ":" + elem.getNom());
					triangleInsert.executeUpdate();
				}
			}
			return true;
		} catch (SQLException e) {
			System.out.println("le nom du dessin existe deja,veuillez choisir un autre nom !!");
			return false;
		}

	}

	@Override
	public Dessin find(String id) {
		Dessin dessin = null;
		Dao<?> dao;
		try (PreparedStatement select = this.connect.prepareStatement("SELECT D.nomDessin FROM Dessin D WHERE D.nomDessin = ?");
				PreparedStatement selectRectangle = this.connect
						.prepareStatement("SELECT * FROM RectangleDessin RD WHERE RD.nomDessin = ?");
				PreparedStatement selectTriangle = this.connect
						.prepareStatement("SELECT * FROM TriangleDessin TD WHERE TD.nomDessin = ?");
				PreparedStatement selectCercle = this.connect
						.prepareStatement("SELECT * FROM CercleDessin CD WHERE CD.nomDessin = ?");
				PreparedStatement selectCarre = this.connect
						.prepareStatement("SELECT * FROM CarreDessin CD WHERE CD.nomDessin = ?");
				PreparedStatement selectGroupe = this.connect
						.prepareStatement("SELECT * FROM GroupeDessin GD WHERE GD.nomDessin = ?");) {
			select.setString(1, id);
			selectTriangle.setString(1, id);
			selectCarre.setString(1, id);
			selectRectangle.setString(1, id);
			selectCercle.setString(1, id);
			selectGroupe.setString(1, id);
			try (ResultSet res = select.executeQuery();
					ResultSet resTriangle = selectTriangle.executeQuery();
					ResultSet resCarre = selectCarre.executeQuery();
					ResultSet resRectangle = selectRectangle.executeQuery();
					ResultSet resCercle = selectCercle.executeQuery();
					ResultSet resGroupe = selectGroupe.executeQuery();) {

				dessin = new Dessin(id);
				int count=0;
				while (resCarre.next()) {
					dao = new CarreDao();
					dessin.addGraphic((Carre) dao.find(resCarre.getString("nom")));
					count++;
				}

				while (resRectangle.next()) {
					dao = new RectangleDao();
					dessin.addGraphic((Rectangle) dao.find(resRectangle.getString("nom")));
					count++;
				}

				while (resTriangle.next()) {
					dao = new TriangleDao();
					dessin.addGraphic((Triangle) dao.find(resTriangle.getString("nom")));
					count++;
				}

				while (resCercle.next()) {
					dao = new CercleDao();
					dessin.addGraphic((Cercle) dao.find(resCercle.getString("nom")));
					count++;
				}

				while (resGroupe.next()) {
					dao = new GroupeDao();
					dessin.addGraphic((Groupe) dao.find(resGroupe.getString("nom")));
					count++;
				}		
				if(count==0) {
					System.out.println("le dessin est vide");

				}

			}
		} catch (SQLException e) {
			System.out.println("Ce nom de dessin est deja utilise ou invalide\n");
			e.printStackTrace();
		}

		return dessin;
	}

	@Override
	public boolean delete(String id) {
		try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Dessin D WHERE D.nomDessin = ?");) {
			delete.setString(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
