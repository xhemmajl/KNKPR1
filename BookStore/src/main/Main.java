package main;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		VBox vBoxMain = new VBox(20);
		
		String btnStyle = "-fx-background-color:rgb(228,0,70);";
		Font btnFont = Font.font("Times New Roman",FontWeight.BOLD,15);
		
		HBox hBox1 = new HBox(130);
		hBox1.setPadding(new Insets(25,25,25,25));
		hBox1.setStyle("-fx-background-color:rgb(228,0,70);");
		
		
		Label lblBookstore = new Label("BookStore");
		lblBookstore.setFont(Font.font("Sans-serif",FontWeight.BOLD,20));
		lblBookstore.setTextFill(Color.WHITE);
		
		TextField tfKerko = new TextField();
		tfKerko.setPrefWidth(450);
		tfKerko.setPrefHeight(35);
		
		Button btnKerko = new Button("Kerko");
		btnKerko.setStyle("-fx-background-color:rgb(51,51,51);");
		btnKerko.setTextFill(Color.WHITE);
		btnKerko.setPrefSize(100, 35);
		btnKerko.setFont(btnFont);
		
		btnKerko.setOnMouseEntered(e->{
			btnKerko.setCursor(Cursor.HAND);
		});
		
	
		
		Button btnShitjet = new Button("Shitjet");
		btnShitjet.setStyle(btnStyle);
		btnShitjet.setTextFill(Color.WHITE);
		btnShitjet.setPrefSize(100, 30);
		btnShitjet.setFont(btnFont);
		
		btnShitjet.setOnMouseEntered(e->{
			btnShitjet.setCursor(Cursor.HAND);
		});


		
		Button btnBlerjet = new Button("Blerjet");
		btnBlerjet.setStyle(btnStyle);
		btnBlerjet.setTextFill(Color.WHITE);
		btnBlerjet.setPrefSize(100, 30);
		btnBlerjet.setFont(btnFont);

		btnBlerjet.setOnMouseEntered(e->{
			btnBlerjet.setCursor(Cursor.HAND);
		});

		
		Button btnShkyqu = new Button("Shkyqu");
		btnShkyqu.setStyle(btnStyle);
		btnShkyqu.setTextFill(Color.WHITE);
		btnShkyqu.setPrefSize(100, 30);
		btnShkyqu.setFont(btnFont);

		btnShkyqu.setOnMouseEntered(e->{
			btnShkyqu.setCursor(Cursor.HAND);
		});
		
		HBox hBoxButonat = new HBox(5);
		hBoxButonat.getChildren().addAll(btnShitjet,btnBlerjet,btnShkyqu);
		hBoxButonat.setStyle("-fx-background-color:rgb(228,0,70);");
		
		HBox hBoxKerko = new HBox();
		hBoxKerko.getChildren().addAll(tfKerko,btnKerko);
		
		hBox1.getChildren().addAll(lblBookstore,hBoxKerko, hBoxButonat);				
		
		vBoxMain.getChildren().addAll(hBox1);
		
		// Pjesa nen header
		HBox hbTimeline = new HBox(30);
		
		VBox vbKategorite = new VBox(); //per hiperlinkat
		vbKategorite.setPadding(new Insets(20,60,20,60));
		
		Label lblZgjedh = new Label("Kategorite");
		
		
		Hyperlink hpBook1 = new Hyperlink("Poezi");
		Hyperlink hpBook2 = new Hyperlink("Romane");
		Hyperlink hpBook3 = new Hyperlink("Shkencor");
		Hyperlink hpBook4 = new Hyperlink("Per Femij");
		Hyperlink hpBook5 = new Hyperlink("Biografik");
		Hyperlink hpBook6 = new Hyperlink("Per nxenes");
		Hyperlink hpBook7 = new Hyperlink("Komedi");
		Hyperlink hpBook8 = new Hyperlink("Fantazi");
		
		hpBook1.setOnAction(e->{
			
		});
		
		lblZgjedh.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 25));
		hpBook1.setFont(Font.font("monospace",17));
		hpBook2.setFont(Font.font("monospace",17));
		hpBook3.setFont(Font.font("monospace",17));
		hpBook4.setFont(Font.font("monospace",17));
		hpBook5.setFont(Font.font("monospace",17));
		hpBook6.setFont(Font.font("monospace",17));
		hpBook7.setFont(Font.font("monospace",17));
		hpBook8.setFont(Font.font("monospace",17));

				
		vbKategorite.getChildren().addAll(lblZgjedh,hpBook1,hpBook2,hpBook3,
				hpBook4,hpBook5,hpBook6,hpBook7,hpBook8);
		
		vbKategorite.setStyle(" -fx-background-color: linear-gradient(to top left, #cb2d3e, #ef473a);-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"); //me gjet naj ngjyr tmir
		hpBook1.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook2.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook3.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook4.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook5.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook6.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook7.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook8.setStyle("-fx-text-fill: #f7cfd7;");

		lblZgjedh.setStyle("-fx-text-fill: #d39e17;");
		//lblZgjedh.setPadding(new Insets(10, 10, 20, 10));
			
		
		//vbKategorite.setMaxWidth(250);
		vbKategorite.setAlignment(Pos.CENTER);
		
		//  vbKategorite.setSpacing(-15);
		//	VBox.setMargin(vbKategorite, new Insets(20,20,10,40));
		
		// slideshow
		Image imgTimeline = new Image("images/timeline.jpg");
		ImageView ivTimeline = new ImageView(imgTimeline);
		ivTimeline.setFitWidth(1000);
		ivTimeline.setFitHeight(350);
		ivTimeline.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		
		
		hbTimeline.getChildren().add(vbKategorite);
		hbTimeline.getChildren().add(ivTimeline);
		//hbTimeline.setPadding(new Insets(20,20,20,30));
		
		vBoxMain.getChildren().add(hbTimeline);
		
		// books
		HBox hbBooks = new HBox(15);
		
		List<Book> books = Book.getBooks();
		BookPane[] bookPane = new BookPane[5];
		for(int i=0;i<5;i++) {
			bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
			hbBooks.getChildren().add(bookPane[i]);
		}
		
		StackPane sellPane = new StackPane();
		sellPane.setStyle("-fx-background-color:white;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		
		
		ImageView ivPlus = new ImageView(new Image("images/PLUS.png"));
		ivPlus.setFitHeight(67);
		ivPlus.setFitWidth(69);
		
		
		Button btnSell = new Button("",ivPlus);
		btnSell.setStyle("-fx-background-color:white;");
		
		btnSell.setOnMouseEntered(e->{
			btnSell.setCursor(Cursor.HAND);
		});
		sellPane.getChildren().add(btnSell);
		sellPane.setPrefWidth(400);
		
		hbBooks.getChildren().add(sellPane);
		
		
		vBoxMain.getChildren().add(hbBooks);
		
		vBoxMain.setPadding(new Insets(10,15,10,15));
		Scene scene = new Scene(vBoxMain);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
