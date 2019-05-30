package main;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class BookPane extends FlowPane{
	Label lblTitle=new Label("");
	Label lblAuthor  = new Label(""); 
	Label lblGenre = new Label(String.valueOf(""));
	Label lblPublicationYear = new Label(String.valueOf("")); 
	Label lblPrice= new Label("");
	Button btnBlej = new Button("Blej");
	
	
	Font lblFont = Font.font("monospace",20);
	
	
	public BookPane(int bookId,String title,String author,String genre, int publicationYear,double price) {
		setOrientation(Orientation.VERTICAL);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10,10,0,10));
		setVgap(30);
		setStyle("-fx-background-color: pink;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		setMargin(this, new Insets(10,20,20,10));
		setWidth(200);
		lblTitle.setPrefWidth(200);
		lblTitle.setWrapText(true);
		
		lblTitle.setTextAlignment(TextAlignment.CENTER);
		lblTitle.setAlignment(Pos.TOP_CENTER);
		
		btnBlej.setAlignment(Pos.BOTTOM_CENTER);
		btnBlej.setStyle("-fx-background-color: \r\n" + 
				"        linear-gradient(#ffd65b, #e68400),\r\n" + 
				"        linear-gradient(#ffef84, #f2ba44),\r\n" + 
				"        linear-gradient(#ffea6a, #efaa22),\r\n" + 
				"        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n" + 
				"        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n" + 
				"    -fx-background-radius: 30;\r\n" + 
				"    -fx-background-insets: 0,1,2,3,0;\r\n" + 
				"    -fx-text-fill: #654b00;\r\n" + 
				"    -fx-font-weight: bold;\r\n" + 
				"    -fx-font-size: 14px;\r\n" + 
				"    -fx-padding: 10 20 10 20;");
		lblTitle.setFont(lblFont);
		
		lblTitle.setText(title);
		lblAuthor.setText(author);
		lblGenre.setText(genre);
		lblPublicationYear.setText(String.valueOf(publicationYear));
		lblPrice.setText(String.valueOf(price));
		
		GridPane gPane = new GridPane();
		gPane.addRow(0, new Label("Autori: "),lblAuthor);
		gPane.addRow(1, new Label("Kategoria: "),lblGenre);
		gPane.addRow(2, new Label("Viti: "),lblPublicationYear);	
		gPane.addRow(3, new Label("Cmimi: "),lblPrice);
		getChildren().addAll(lblTitle,gPane,btnBlej);


		
	}
}
