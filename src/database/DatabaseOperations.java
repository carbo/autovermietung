package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PKW;
import model.User;

public class DatabaseOperations {
	public ArrayList<PKW> getAutos() {
		Datenverbindung datenverbindung = new Datenverbindung();
    	Connection connection = datenverbindung.getDriverManagerConnection();
		ArrayList<PKW> autos = new ArrayList<PKW>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from scott.pkw");
			PKW pkw = null;
			while(rs.next()) {
				pkw = new PKW(rs.getString("Kennzeichen"), rs.getInt("Preis"));
				pkw.setFrei(rs.getBoolean("frei"));
				autos.add(pkw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return autos;
	}
	
	public void deleteCar(String kennzeichen) {
		Datenverbindung datenverbindung = new Datenverbindung();
		Connection conn = datenverbindung.getDriverManagerConnection();
		try {
			String sql = "DELETE FROM scott.pkw WHERE kennzeichen = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kennzeichen);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateCar(boolean ausleihen, String kennzeichen) {
		Datenverbindung datenverbindung = new Datenverbindung();
		Connection conn = datenverbindung.getDriverManagerConnection();
		try {
			String sql = "UPDATE scott.pkw SET frei=? WHERE kennzeichen = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, ausleihen);
			statement.setString(2, kennzeichen);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insertCar(String kennzeichen, int km) {
		Connection conn = null;
		try {
			Datenverbindung datenverbindung = new Datenverbindung();
			conn = datenverbindung.getDriverManagerConnection();
			String sql = "INSERT INTO scott.pkw(kennzeichen, preis, frei)VALUES (?, ?, true)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, kennzeichen);
			statement.setInt(2, km);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public User getUser(User userObjekt) {
		Connection connection = null;
		try {
			Datenverbindung datenverbindung = new Datenverbindung();
			connection = datenverbindung.getDriverManagerConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from scott.benutzer");
			while(rs.next()) {
				userObjekt = new User();
				userObjekt.setName(rs.getString("name"));
				userObjekt.setPassword(rs.getString("password"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userObjekt;
	}

}
