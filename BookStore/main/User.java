package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	private static String username;
	private int id;
	private String firstName;
	private String lastName;
	
	public User(String username) {
		this.username=username;
		setIdFromDB();
		setFirstnameFromDB();
		setLastnameFromDB();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastname() {
		return lastName;
	}
	
	public void setLastname(String lastName) {
		this.lastName=lastName;
	}
	
	public void setIdFromDB() {
		String query = "select uID from users WHERE username = '"+getUsername()+"'";
		try {
			Statement stm = DatabaseConnection.getConnection().createStatement();
			ResultSet result = stm.executeQuery(query);
			if(result.next())
				setId(result.getInt("uID"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setFirstnameFromDB() {
		String query = "select firstName from users WHERE username = '"+getUsername()+"'";
		try {
			Statement stm = DatabaseConnection.getConnection().createStatement();
			ResultSet result = stm.executeQuery(query);
			if(result.next())
				setFirstname(result.getString("firstName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setLastnameFromDB() {
		String query = "select lastName from users WHERE username = '"+getUsername()+"'";
		try {
			Statement stm = DatabaseConnection.getConnection().createStatement();
			ResultSet result = stm.executeQuery(query);
			if(result.next())
				setLastname(result.getString("lastName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		User user = new User("taulantisaku");
		System.out.println(user.getFirstname()+user.getId());
	}
	
}


