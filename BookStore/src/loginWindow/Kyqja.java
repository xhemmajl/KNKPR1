package loginWindow;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kyqja extends Application{
	
	private TextField tfPerdoruesi = new TextField();
	private PasswordField tfFjalekalimi = new PasswordField();

	
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException{
		primaryStage.setResizable(false);
		
		BorderPane bPane = new BorderPane();
		
		GridPane gridPane = new GridPane();
		

		bPane.setCenter(gridPane);
		
		
		gridPane.setPadding(new Insets(10,100,100,100));
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		Image imgUsername = new Image("images/username.png");
		ImageView ivUsername = new ImageView(imgUsername);
		Image imgPassword = new Image("images/password.png");
		ImageView ivPassword = new ImageView(imgPassword);
		Image imgLogo = new Image("images/logo.png");
		ImageView ivLogo = new ImageView(imgLogo);
		
		bPane.setTop(ivLogo);
		bPane.setAlignment(ivLogo, Pos.CENTER);
	
		Label lblRegjistrohu = new Label("Regjistrohu");
		Label lblBookstore = new Label("Book Store");
		lblBookstore.setFont(Font.font("Times New Roman", 30));
		
		tfPerdoruesi.setPromptText("Perdorusi");
		tfPerdoruesi.setPrefWidth(300);
		tfFjalekalimi.setPromptText("Fjalekalimi");
		
		
		CheckBox cbRuajFjalekalimin = new CheckBox("Mbaj mend fjalekalimin");
		
		Button btnKyqu = new Button("Kyqu");
		Button btnAnulo = new Button("Anulo");
		btnKyqu.setPrefWidth(145);
		btnAnulo.setPrefWidth(145);
		//
		Hyperlink hlRegjistrohu = new Hyperlink("Regjistrohu");
		hlRegjistrohu.setOnAction(e->{
			Regjistrimi regjistrimi = new Regjistrimi();
			try {
				regjistrimi.start(primaryStage);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnKyqu.setOnAction(e->kyqu());
		btnAnulo.setOnAction(e->anulo());
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(new Label("Nuk jeni te regjistruar?"),hlRegjistrohu);
		hBox.setAlignment(Pos.CENTER_LEFT);
		
		
		gridPane.add(lblBookstore,1,0);
		gridPane.add(ivUsername,0,1);
		gridPane.add(tfPerdoruesi, 1, 1);
		gridPane.add(ivPassword, 0, 2);
		gridPane.add(tfFjalekalimi, 1, 2);
		gridPane.add(cbRuajFjalekalimin, 1, 3);
		gridPane.add(btnKyqu, 1, 4);
		gridPane.add(btnAnulo, 1, 4);
		gridPane.add(hBox, 1, 5);
		
		gridPane.setHalignment(btnAnulo, HPos.RIGHT);
		gridPane.setHalignment(hlRegjistrohu,HPos.CENTER);
		gridPane.setHalignment(lblBookstore, HPos.CENTER);
		gridPane.setStyle("-fx-background-color:white;");
		bPane.setStyle("-fx-background-color:white;");

		
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("Kyqja");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
	}
	
	public void kyqu() {
		if(isPasswordCorrect()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Jeni kyqur me sukses!");
			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Perdoruesi ose fjalekalimi jane gabim!");
			alert.showAndWait();
		}
	}
	
	public boolean isPasswordCorrect() {
		String query = "select * from users where username = ? and password = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1,tfPerdoruesi.getText());
			preparedStatement.setString(2, tfFjalekalimi.getText());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			return (resultSet.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public void anulo() {
		tfPerdoruesi.setText("");
		tfFjalekalimi.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
