package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kyqja extends Application{
	
	private TextField tfPerdoruesi = new TextField();
	private PasswordField tfFjalekalimi = new PasswordField();
	ComboBox<String> languagesCbo = new ComboBox<>();

	
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException{
		primaryStage.setResizable(false);
		
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(40,50,40,50));

		
		

		gridPane.setVgap(20);
		gridPane.setHgap(20);
		Image imgUsername = new Image("images/username.png");
		ImageView ivUsername = new ImageView(imgUsername);
		Image imgPassword = new Image("images/password.png");
		ImageView ivPassword = new ImageView(imgPassword);
		Image imgLogo = new Image("images/logo.png");
		ImageView ivLogo = new ImageView(imgLogo);
		

	
		//Label lblRegjistrohu = new Label("Regjistrohu");
		Label lblRegjistrohu = I18N.getLabel("Regjistrohu");
		Label lblBookstore = new Label("Book Store");
		lblBookstore.setFont(Font.font("Times New Roman", 30));
		
		tfPerdoruesi.setPromptText("Perdorusi");
		tfPerdoruesi.setPrefWidth(300);
		tfFjalekalimi.setPromptText("Fjalekalimi");
		
		
		//CheckBox cbRuajFjalekalimin = new CheckBox("Mbaj mend fjalekalimin");
		CheckBox cbRuajFjalekalimin = I18N.getCheckBox("MbajMendFjalekalimin");
		
		//Button btnKyqu = new Button("Kyqu");
		Button btnKyqu = I18N.getButton("Kyqu");
		//Button btnAnulo = new Button("Anulo");
		Button btnAnulo = I18N.getButton("Anulo");
		btnKyqu.setPrefWidth(145);
		btnAnulo.setPrefWidth(145);
		
		//Hyperlink hlRegjistrohu = new Hyperlink("Regjistrohu");
		Hyperlink hlRegjistrohu = I18N.getHyperlink("Regjistrohu");
		hlRegjistrohu.setOnAction(e->{
			Regjistrimi regjistrimi = new Regjistrimi();
			try {
				regjistrimi.start(primaryStage);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Main main = new Main();
		Stage mainStage = new Stage();
		btnKyqu.setOnAction(e->{
			if(kyqu()) {
				UserInfo.USERNAME=tfPerdoruesi.getText();
				main.start(mainStage);
				primaryStage.close();
			}
		});
		btnAnulo.setOnAction(e->anulo());
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(I18N.getLabel("NukJeniTeRegjistruar"),hlRegjistrohu);
		hBox.setAlignment(Pos.CENTER_LEFT);
		
		gridPane.add(ivLogo, 1, 0);
		gridPane.add(lblBookstore,1,1);
		gridPane.add(ivUsername,0,2);
		gridPane.add(tfPerdoruesi, 1, 2);
		gridPane.add(ivPassword, 0, 3);
		gridPane.add(tfFjalekalimi, 1, 3);
		gridPane.add(cbRuajFjalekalimin, 1, 4);
		gridPane.add(btnKyqu, 1, 5);
		gridPane.add(btnAnulo, 1, 5);
		gridPane.add(hBox, 1, 6);
		
		gridPane.setHalignment(btnAnulo, HPos.RIGHT);
		gridPane.setHalignment(hlRegjistrohu,HPos.CENTER);
		gridPane.setHalignment(lblBookstore, HPos.CENTER);
		gridPane.setStyle("-fx-background-color:white;");
		gridPane.setHalignment(ivLogo, HPos.CENTER);
	//	vbox.setStyle("-fx-background-color:white;");
		
		// MULTILANGUAGE
		ObservableList<String> allowedLanguage = FXCollections.observableArrayList();
		
		for(int i=0;i<I18N.getLanguages().size();i++) {
			allowedLanguage.add(I18N.getLanguages().get(i).getLanguage());
		}
		
		
		languagesCbo.getItems().addAll(allowedLanguage);
		languagesCbo.setValue(I18N.getDefaultLocale().getLanguage());
		languagesCbo.setOnAction(e->switchLanguage());
		
		gridPane.add(languagesCbo,1,7);
		gridPane.setHalignment(languagesCbo, HPos.RIGHT);

		
		
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Kqyja");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
	}
	
	public void switchLanguage() {
		I18N.setLocale(new Locale(languagesCbo.getValue()));
	}
	
	public boolean kyqu() {
		if(isPasswordCorrect()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Jeni kyqur me sukses!");
			alert.showAndWait();
			return true;
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Perdoruesi ose fjalekalimi jane gabim!");
			alert.showAndWait();
			return false;
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