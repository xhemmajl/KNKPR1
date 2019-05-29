package main;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Book{
	private String title;
	private String author;
	private String genre;
	private int publicationYear;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String title,String author,String genre, int publicationYear,double price) {
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
		setPublicationYear(publicationYear);
		setPrice(price);
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


}
