package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
		VBox vBoxMain = new VBox();
		
		String btnStyle = "-fx-background-color:rgb(228,0,70);";
		Font btnFont = Font.font("Times New Roman",FontWeight.BOLD,15);
		
		HBox hBox1 = new HBox(170);
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
		
		Button btnShitjet = new Button("Shitjet");
		btnShitjet.setStyle(btnStyle);
		btnShitjet.setTextFill(Color.WHITE);
		btnShitjet.setPrefSize(100, 30);
		btnShitjet.setFont(btnFont);


		
		Button btnBlerjet = new Button("Blerjet");
		btnBlerjet.setStyle(btnStyle);
		btnBlerjet.setTextFill(Color.WHITE);
		btnBlerjet.setPrefSize(100, 30);
		btnBlerjet.setFont(btnFont);


		
		Button btnShkyqu = new Button("Shkyqu");
		btnShkyqu.setStyle(btnStyle);
		btnShkyqu.setTextFill(Color.WHITE);
		btnShkyqu.setPrefSize(100, 30);
		btnShkyqu.setFont(btnFont);


		
		HBox hBoxButonat = new HBox(5);
		hBoxButonat.getChildren().addAll(btnShitjet,btnBlerjet,btnShkyqu);
		hBoxButonat.setStyle("-fx-background-color:rgb(228,0,70);");
		
		HBox hBoxKerko = new HBox();
		hBoxKerko.getChildren().addAll(tfKerko,btnKerko);
		
		hBox1.getChildren().addAll(lblBookstore,hBoxKerko, hBoxButonat);				
		
		vBoxMain.getChildren().addAll(hBox1);
		
		
		VBox vb = new VBox(); //per hiperlinkat
		
		Label lblZgjedh = new Label("Zgjedh librin");
		
		
		Hyperlink hpBook1 = new Hyperlink("Poezi");
		Hyperlink hpBook2 = new Hyperlink("Romane");
		Hyperlink hpBook3 = new Hyperlink("Shkencor");
		Hyperlink hpBook4 = new Hyperlink("Per Femij");
		Hyperlink hpBook5 = new Hyperlink("Ekonomik");
		Hyperlink hpBook6 = new Hyperlink("Biografik");
		Hyperlink hpBook7 = new Hyperlink("Per nxenes");
		Hyperlink hpBook8 = new Hyperlink("Komedi");
		Hyperlink hpBook9 = new Hyperlink("Mjeksi");
		Hyperlink hpBook10 = new Hyperlink("Religjion");
		Hyperlink hpBook11 = new Hyperlink("Fantazi");
		
		lblZgjedh.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 30));
		hpBook1.setFont(Font.font("monospace",25));
		hpBook2.setFont(Font.font("monospace",25));
		hpBook3.setFont(Font.font("monospace",25));
		hpBook4.setFont(Font.font("monospace",25));
		hpBook5.setFont(Font.font("monospace",25));
		hpBook6.setFont(Font.font("monospace",25));
		hpBook7.setFont(Font.font("monospace",25));
		hpBook8.setFont(Font.font("monospace",25));
		hpBook9.setFont(Font.font("monospace",25));
		hpBook10.setFont(Font.font("monospace",25));
		hpBook11.setFont(Font.font("monospace",25));
				
		vb.getChildren().addAll(lblZgjedh,hpBook1,hpBook2,hpBook3,
				hpBook4,hpBook5,hpBook6,hpBook7,hpBook8,
				hpBook9,hpBook10,hpBook11);
		
		vb.setStyle(" -fx-background-color: linear-gradient(to top left, #cb2d3e, #ef473a);"); //me gjet naj ngjyr tmir
		hpBook1.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook2.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook3.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook4.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook5.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook6.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook7.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook8.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook9.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook10.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook11.setStyle("-fx-text-fill: #f7cfd7;");
		lblZgjedh.setStyle("-fx-text-fill: #d39e17;");
		lblZgjedh.setPadding(new Insets(10, 10, 20, 10));
			
		
		vb.setMaxWidth(300);
		vb.setAlignment(Pos.CENTER);
		
		
		vb.setSpacing(-15);
		VBox.setMargin(vb, new Insets(20,20,20,40));
		
				
		vBoxMain.getChildren().add(vb); 
		
		
		
		
		
		Scene scene = new Scene(vBoxMain);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
