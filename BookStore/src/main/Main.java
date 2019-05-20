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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(15,15,15,15));
		borderPane.setStyle("-fx-background-image:url(images/book.jpg);-fx-background-repeat:no-repeat;-fx-background-position:center;-fx-height:100%; -fx-width:100%; -fx-background-size:cover;");
		//search icon
		
		HBox hbox = new HBox(20);
		
		
		hbox.setAlignment(Pos.CENTER);
		
		
		BorderPane.setMargin(hbox, new Insets(30,0,0,0));
		
		
		
		Scene scene = new Scene(borderPane);
		primaryStage.setMaximized(true);
		primaryStage.setTitle("Shit-blerje e librave Online");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
