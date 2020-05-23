package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import uvsq.bean.*;
import uvsq.dao.*;

public class GroupeDao extends Dao<Groupe> {

	@Override
	public boolean create(Groupe obj) {
		String prefix = Dao.nom + ":";
		try (PreparedStatement groupeInsert = this.connect.prepareStatement("INSERT INTO Groupe(nomGroup) values(?)");
				PreparedStatement carreInsert = this.connect
						.prepareStatement("INSERT INTO CarreGroupe(nomGroup, nom) VALUES(?, ?)");
				PreparedStatement cercleInsert = this.connect
						.prepareStatement("INSERT INTO CercleGroupe(nomGroup, nom) VALUES(?, ?)");
				PreparedStatement triangleInsert = this.connect
						.prepareStatement("INSERT INTO TriangleGroupe(nomGroup, nom) VALUES(?, ?)");
				PreparedStatement groupeGroupeInsert = this.connect
						.prepareStatement("INSERT INTO GroupeGroupe(nomGroup, nom) VALUES(?, ?)");
				PreparedStatement rectangleInsert = this.connect
						.prepareStatement("INSERT INTO RectangleGroupe(nomGroup, nom) VALUES(?, ?)")) {
			groupeInsert.setString(1, prefix + obj.getNom());
			groupeInsert.executeUpdate();
			List<Graphic> listElem = obj.getListeNonModifiable();
			Dao tmp;
			for (Graphic elem : listElem) {

				if (elem instanceof Groupe) {
					tmp = new GroupeDao();
					tmp.create((Groupe) elem);
					groupeGroupeInsert.setString(1, prefix + obj.getNom());
					groupeGroupeInsert.setString(2, prefix + elem.getNom());
					groupeGroupeInsert.executeUpdate();
				} else if (elem instanceof Cercle) {
					tmp = new CercleDao();
					tmp.create((Cercle) elem);
					cercleInsert.setString(1, prefix + obj.getNom());
					cercleInsert.setString(2, prefix + elem.getNom());
					cercleInsert.executeUpdate();
				} else if (elem instanceof Rectangle) {
					tmp = new RectangleDao();
					tmp.create((Rectangle) elem);
					rectangleInsert.setString(1, prefix + obj.getNom());
					rectangleInsert.setString(2, prefix + elem.getNom());
					rectangleInsert.executeUpdate();
				} else if (elem instanceof Carre) {
					tmp = new CarreDao();
					tmp.create((Carre) elem);
					carreInsert.setString(1, prefix + obj.getNom());
					carreInsert.setString(2, prefix + elem.getNom());
					carreInsert.executeUpdate();
				} else if (elem instanceof Triangle) {
					tmp = new TriangleDao();
					tmp.create((Triangle) elem);
					triangleInsert.setString(1, prefix + obj.getNom());
					triangleInsert.setString(2, prefix + elem.getNom());
					triangleInsert.executeUpdate();
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Groupe find(String id) {
		Groupe g = null;
		Dao dao;
		try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Groupe G WHERE G.nomGroup = ?");
				PreparedStatement selectRectangle = this.connect
						.prepareStatement("SELECT * FROM RectangleGroupe RG WHERE RG.nomGroup = ?");
				PreparedStatement selectTriangle = this.connect
						.prepareStatement("SELECT * FROM TriangleGroupe TG WHERE TG.nomGroup = ?");
				PreparedStatement selectCercle = this.connect
						.prepareStatement("SELECT * FROM CercleGroupe CG WHERE CG.nomGroup = ?");
				PreparedStatement selectCarre = this.connect
						.prepareStatement("SELECT * FROM CarreGroupe CG WHERE CG.nomGroup = ?");
				PreparedStatement selectGroupe = this.connect
						.prepareStatement("SELECT * FROM GroupeGroupe GG WHERE GG.nomGroup = ?");) {
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
				if (res.next()) {
					String n = res.getString("nomGroup").split(":")[1];
					g = new Groupe(n);
				}

				while (resCarre.next()) {
					dao = new CarreDao();
					g.ajoutForme((Carre) dao.find(resCarre.getString("nom")));
				}

				while (resRectangle.next()) {
					dao = new RectangleDao();
					g.ajoutForme((Rectangle) dao.find(resRectangle.getString("nom")));
				}

				while (resTriangle.next()) {
					dao = new TriangleDao();
					g.ajoutForme((Triangle) dao.find(resTriangle.getString("nom")));
				}

				while (resCercle.next()) {
					dao = new CercleDao();
					g.ajoutForme((Cercle) dao.find(resCercle.getString("nom")));
				}

				while (resGroupe.next()) {
					dao = new GroupeDao();
					g.ajoutForme((Groupe) dao.find(resGroupe.getString("nom")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return g;
	}

	@Override
	public boolean delete(String id) {
		try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Groupe G WHERE G.nomGroup = ?");) {
			delete.setString(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
