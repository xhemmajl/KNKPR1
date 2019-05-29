package main;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class BookPane extends FlowPane{
	Book book = new Book();
	Label lblTitle = new Label(book.getTitle());
	Label lblAuthor = new Label(book.getAuthor());
	Label lblGenre = new Label(book.getGenre());
	Label lblPublicationYear = new Label(book.getPublicationYear());
	Label lblPrice = new Label(book.getPrice());
	
	public BookPane() {
		setOrientation(Orientation.VERTICAL);
		
	}
}
