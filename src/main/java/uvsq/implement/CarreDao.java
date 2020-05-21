package uvsq.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq.bean.*;
import uvsq.dao.*;


public class CarreDao extends Dao<Carre> {

  @Override
  public boolean create(Carre obj) {
	  this.connect();
    try (PreparedStatement carreInsert =
        this.connect.prepareStatement("INSERT INTO Carre(nom, x, y, cote) values(?, ?, ?, ?)"); ) {
      carreInsert.setString(1, Dao.nom + ":" + obj.getNom());
      carreInsert.setInt(2, obj.getPointDOrigine().getX());
      carreInsert.setInt(3, obj.getPointDOrigine().getY());
      carreInsert.setInt(4, obj.getCote());
      carreInsert.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    
  }

  @Override
  public Carre find(String id) {
    Carre c = null;
    this.connect();
    try (PreparedStatement select =
        this.connect.prepareStatement("SELECT * FROM Carre C WHERE C.nom = ?")) {
      select.setString(1, id);
      try (ResultSet res = select.executeQuery()) {
        if (res.next()) {
          c =
              new Carre(
                  res.getString("nom").split(":")[1],
                  new Point(
                      Integer.parseInt(res.getString("x")), Integer.parseInt(res.getString("y"))),
                  Integer.parseInt(res.getString("cote")));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return c;
  }

  @Override
  public boolean delete(String id) {
    this.connect();
    try (PreparedStatement delete =
        this.connect.prepareStatement("DELETE FROM Carre C WHERE C.nom = ?"); ) {
      delete.setString(1, id);
      delete.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

  }


}
