package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq.bean.*;
import uvsq.dao.*;

public class CercleDao extends Dao<Cercle> {
	
	@Override
	public boolean create(Cercle obj) {
		//this.connect();
		try (PreparedStatement insert = this.connect
				.prepareStatement("INSERT INTO Cercle(nom, x, y, rayon) values(?, ?, ?, ?)");) {
			insert.setString(1, Dao.nom + ":" + obj.getNom());
			insert.setInt(2, obj.getCentre().getX());
			insert.setInt(3, obj.getCentre().getY());
			insert.setInt(4, obj.getRayon());
			insert.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cercle find(String id) {
		Cercle c = null;
	//	this.connect();
		try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Cercle C WHERE C.nom = ?")) {
			select.setString(1, id);
			try (ResultSet res = select.executeQuery()) {
				if (res.next()) {
					c = new Cercle(res.getString("nom").split(":")[1],
							new Point(Integer.parseInt(res.getString("x")), Integer.parseInt(res.getString("y"))),
							Integer.parseInt(res.getString("rayon")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public boolean delete(String id) {
	//	this.connect();
		try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Cercle C WHERE C.nom = ?");) {
			delete.setString(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
