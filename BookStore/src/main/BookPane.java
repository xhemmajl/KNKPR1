package main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class BookPane extends FlowPane{
	Label lblTitle=new Label("");
	Label lblAuthor  = new Label(""); 
	Label lblGenre = new Label(String.valueOf(""));
	Label lblPublicationYear = new Label(String.valueOf("")); 
	Label lblPrice= new Label("");
	Button btnBlej = new Button("Blej");
	int bookID;
	
	Font lblFont = Font.font("monospace",20);
	
	
	public BookPane(int bookId,String title,String author,String genre, int publicationYear,double price) {
		this.bookID=bookId;
		setOrientation(Orientation.VERTICAL);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10,10,0,10));
		setVgap(30);
		setStyle("-fx-background-color: linear-gradient(to top left, #FAE3E3, #ef473a);-fx-effect: dropshadow(three-pass-box, rgba(0,0,10,0.8), 10, 0, 0, 0);");
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

		btnBlej.setCursor(Cursor.HAND);
		

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
		
		btnBlej.setOnAction(e->{
			String query1 = "DELETE FROM Book WHERE bookID = ?";
			try {
				PreparedStatement preparedStm = DatabaseConnection.getConnection().prepareStatement(query1);
				preparedStm.setInt(1, bookId);
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Konfirmim");
				alert.setHeaderText("A jeni te sigurte qe doni ta bleni kete liber?");
				alert.setContentText("Libri do te vije tek adresa te cilen e keni dhene kur jeni regjistruar, 5 dite pas porosise.\n"
						+ "Pagesa behet me rastin e pranimit te librit.\n");
				
				Optional<ButtonType> alertResult = alert.showAndWait();
				if(alertResult.get()== ButtonType.OK) {
					preparedStm.executeUpdate();
					Alert infoAlert = new Alert(AlertType.INFORMATION);
					infoAlert.setTitle("INFO DIALOG");
					infoAlert.setHeaderText("Porosia u krye me sukses.\n"
							+ "Faleminderit qe zgjodhet BookStore!");
					infoAlert.showAndWait();

				}
				else
					alert.close();
				Main.hbBooks.getChildren().clear();
				Main.getBooks();
				Main.hbBooks.getChildren().add(Main.sellPane);					
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Cannot insert student in database!");
				alert.setContentText(e1.getMessage());
				alert.showAndWait();
				System.exit(1);
			}
			
			
		});

		lblTitle.setFont(lblFont);
		
		lblTitle.setText(title);
		lblAuthor.setText(author);
		lblGenre.setText(genre);
		lblPublicationYear.setText(String.valueOf(publicationYear));
		lblPrice.setText(String.valueOf(price));
		lblTitle.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD,20));
		lblTitle.setStyle("-fx-text-fill:#350303;");
		lblAuthor.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		lblAuthor.setStyle("-fx-text-fill:#350303;");
		lblGenre.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		lblGenre.setStyle("-fx-text-fill:#350303;");
		lblPublicationYear.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		lblPublicationYear.setStyle("-fx-text-fill:#350303;");
		lblPrice.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		lblPrice.setStyle("-fx-text-fill:#350303;");
		
		GridPane gPane = new GridPane();
		Label authorlb = new Label("Autori :");
		Label kategorilb = new Label("Kategoria :");
		Label vitilb = new Label("Viti: ");
		Label cmimilb = new Label("Cmimi: ");
		authorlb.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		authorlb.setStyle("-fx-text-fill:#350303;");
		kategorilb.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		kategorilb.setStyle("-fx-text-fill:#350303;");
		vitilb.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		vitilb.setStyle("-fx-text-fill:#350303;");
		cmimilb.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		cmimilb.setStyle("-fx-text-fill:#350303;");
		
		lblPrice.setText(lblPrice.getText()+"€");
		
		gPane.addRow(0,authorlb,lblAuthor);
		gPane.addRow(1,kategorilb,lblGenre);
		gPane.addRow(2, vitilb,lblPublicationYear);	
		gPane.addRow(3, cmimilb,lblPrice);
		getChildren().addAll(lblTitle,gPane,btnBlej);


		
	}
}
