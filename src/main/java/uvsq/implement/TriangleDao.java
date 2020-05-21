package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq.bean.*;
import uvsq.dao.*;

public class TriangleDao extends Dao<Triangle> {

	@Override
	public boolean create(Triangle obj) {
		this.connect();
		try (PreparedStatement insert = this.connect
				.prepareStatement("INSERT INTO Triangle(nom, ax, ay, bx, by, cx, cy) values(?, ?, ?, ?, ?, ?, ?)");) {
			insert.setString(1, Dao.nom + ":" + obj.getNom());
			insert.setInt(2, obj.getPointA().getX());
			insert.setInt(3, obj.getPointA().getY());
			insert.setInt(4, obj.getPointB().getX());
			insert.setInt(5, obj.getPointB().getY());
			insert.setInt(6, obj.getPointC().getX());
			insert.setInt(7, obj.getPointC().getY());
			insert.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Triangle find(String id) {
		Triangle t = null;
		this.connect();
		try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Triangle T WHERE T.nom = ?")) {
			select.setString(1, id);
			try (ResultSet res = select.executeQuery()) {
				if (res.next()) {
					t = new Triangle(res.getString("nom").split(":")[1], new Point(res.getInt("ax"), res.getInt("ay")),
							new Point(res.getInt("bx"), res.getInt("by")),
							new Point(res.getInt("cx"), res.getInt("cy")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return t;
	}

	@Override
	public boolean delete(String id) {
		this.connect();
		try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Triangle T WHERE T.nom = ?");) {
			delete.setString(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
