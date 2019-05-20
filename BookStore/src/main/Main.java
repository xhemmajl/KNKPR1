package main;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.TOP_CENTER);
		Label bookStore = new Label("Book Store");
		TextField search = new TextField();
		Button btnKerko = new Button("Kerko");
		Button btnShitjet = new Button("Shitjet");
		Button btnBlerjet = new Button("Blerjet");
		Button btnShkyqu = new Button("Shkyqu");
		hbox1.getChildren().addAll(bookStore,search,btnKerko,btnShitjet,btnBlerjet,btnShkyqu);
		hbox1.setStyle("-fx-background-color:#E40046;");
		hbox1.setPrefHeight(50);
		hbox1.setPadding(new Insets(20,20,20,20));
		search.setPrefSize(50, 50);
		search.setPromptText("Kerko Libra...");
		bookStore.setAlignment(Pos.BASELINE_LEFT);
		VBox vbox1 = new VBox();
		vbox1.getChildren().add(hbox1);
		//vbox1.setPadding(new Insets(20,20,20,20));
		search.setPrefWidth(500);
		bookStore.setFont(Font.font("Times new Roman",FontWeight.BOLD,30));
		
		btnKerko.setTextFill(Color.WHITE);
		btnKerko.setStyle("-fx-background-color:#E40046;");
		
		
		Scene scene = new Scene(vbox1,1400,700);
		primaryStage.setTitle("Shit-blerje e librave Online");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
