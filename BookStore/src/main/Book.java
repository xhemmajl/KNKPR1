package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Book{
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private int publicationYear;
	private double price;
	
	public Book() {
		
	}
	
	public Book(int bookId,String title,String author,String genre, int publicationYear,double price) {
		this.bookId=bookId;
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
		setPublicationYear(publicationYear);
		setPrice(price);
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre=genre;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(int publicationYear) {
		this.publicationYear=publicationYear;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public static boolean insertBook(String title, String author, String genre,String publicationYear,double price) {
		String query = "INSERT INTO Book(title,author,genre,publication_year,price)  VALUES(?,?,?,?,?)";

		
		try {
			PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, genre);
			preparedStatement.setString(4, publicationYear);
			preparedStatement.setDouble(5, price);
			
			return (preparedStatement.executeUpdate()>0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	public static List<Book> getBooks(){
		List<Book> books = new ArrayList();
		
		String query = "SELECT * FROM book ORDER BY bookID desc";
		
		try {
			PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Book book = new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6));
				books.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		
		return books;
	}
	
	public static List<Book> getBooks(String query){
		List<Book> books = new ArrayList();
		
		
		try {
			PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Book book = new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6));
				books.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		}
		
		return books;
	}


}
