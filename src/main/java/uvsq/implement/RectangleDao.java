package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq.bean.*;
import uvsq.dao.*;

public class RectangleDao extends Dao<Rectangle> {

	@Override
	public boolean create(Rectangle obj) {
		try (PreparedStatement insert = this.connect
				.prepareStatement("INSERT INTO Rectangle(nom, x, y, longueur, hauteur) values(?, ?, ?, ?, ?)");) {
			System.out.println("Dans RectangleDao: " + Dao.nom + ":" + obj.getNom());
			insert.setString(1, Dao.nom + ":" + obj.getNom());
			insert.setInt(2, obj.getPointDOrigine().getX());
			insert.setInt(3, obj.getPointDOrigine().getY());
			insert.setInt(4, obj.getLongueur());
			insert.setInt(5, obj.getHauteur());
			insert.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Rectangle find(String id) {
		Rectangle r = null;
		try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Rectangle R WHERE R.nom = ?")) {
			select.setString(1, id);
			try (ResultSet res = select.executeQuery()) {
				if (res.next()) {
					r = new Rectangle(res.getString("nom").split(":")[1],
							new Point(Integer.parseInt(res.getString("x")), Integer.parseInt(res.getString("y"))),
							Integer.parseInt(res.getString("longueur")), Integer.parseInt(res.getString("hauteur")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public boolean delete(String id) {
		try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Rectangle R WHERE R.nom = ?");) {
			delete.setString(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
