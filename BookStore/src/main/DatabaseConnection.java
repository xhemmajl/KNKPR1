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
	private final static String password = "045257900";
	
	
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
