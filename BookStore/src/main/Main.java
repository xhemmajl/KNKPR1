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
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(15,15,15,15));
		
		//search icon
		Image imgSearch = new Image("images/search.png");
		ImageView ivSearch = new ImageView(imgSearch);
		
		
		ivSearch.setOnMouseClicked(e -> {
			//a searching engine for books...
		});
		
		HBox hbox = new HBox();
		
		//Textfield for book search
		TextField searchTxt = new TextField();
		
		searchTxt.setMaxWidth(150);
		searchTxt.setPromptText("Kerko Librin");
		searchTxt.setStyle("-fx-background-color: #b3c3b4;");
		
		
		searchTxt.setFont(Font.font("Times New Roman", 15));
		searchTxt.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				//a searching engine for books...
			}
		});
		
		hbox.getChildren().addAll(searchTxt,ivSearch);
		
		borderPane.setTop(hbox);
		hbox.setAlignment(Pos.CENTER);
		
		BorderPane.setMargin(hbox, new Insets(30,0,0,0));
		
		
		
		Scene scene = new Scene(borderPane,1200,800);
		primaryStage.setTitle("Shit-blerje e librave Online");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	

}
