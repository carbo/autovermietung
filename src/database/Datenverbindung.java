package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Datenverbindung {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String HOST = "localhost";
	private static final int PORT = 5432;
	private static final String DB = "autovermietung";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	public static void main(String[] args) {
		Datenverbindung datenverbindung = new Datenverbindung();
		if(datenverbindung.getDriverManagerConnection() != null) {
			System.out.println("Auch über DriverManager geht es!!!");
		}
		if(datenverbindung.getDriverManagerConnection() != null) {
			System.out.println("Successful connection");
		}
		
		
	}
	
	public Connection getDriverManagerConnection()  {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Hier ist was schief gelaufen:"+e.getMessage());
		}
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+HOST+":"+PORT+"/"+DB, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Hier ist was schief gelaufen:"+e.getMessage());
		}
		return null;
	}

}
