package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatabaseConnection {
	private static Connection dbConnection;
	
	private final static String hostname = "localhost";
	private final static String dbName = "dbbookstore";
	private final static String username = "root";
<<<<<<< HEAD
	private final static String password = "lirimimeri1999#";
=======
	private final static String password = "malimali";
>>>>>>> 21b2208dbffeecba6031ae583af2109654973e6b
	
	
	public static Connection getConnection() {
		
		if(dbConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				dbConnection = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"+dbName+"?useSSL=false",username,password);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return dbConnection;
	}
}
