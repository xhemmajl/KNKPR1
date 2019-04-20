package loginWindow;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LogIn extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		StackPane sPane = new StackPane();
		GridPane gridPane = new GridPane();
		
		sPane.getChildren().add(gridPane);
		
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(5);
		gridPane.setHgap(10);
		
		Label lblUsername = new Label("Username");
		Label lblPassword = new Label("Password");
		Label lblSignup = new Label("Sign Up");
		
		TextField tfUsername = new TextField();
		TextField tfPassword = new TextField();
		
		Button btnLogin = new Button("Log In");
		
		gridPane.add(lblUsername,0,0);
		gridPane.add(tfUsername, 0, 1);
		gridPane.add(lblPassword, 0, 2);
		gridPane.add(tfPassword, 0, 3);
		gridPane.add(btnLogin, 0, 4);
		
		
		Scene scene = new Scene(sPane, 400,400);
		primaryStage.setTitle("Log In");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
