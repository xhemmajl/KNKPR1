package main;


import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class Regjistrimi extends Application{
	//
	ComboBox<String> languagesCbo = new ComboBox<>();

	
	private TextField tfEmri = new TextField();
	private TextField tfMbiemri = new TextField();
	private TextField tfEmriPerdoruesit = new TextField();
	private TextField tfEmailAdresa = new TextField();
	private PasswordField tfFjalekalimi = new PasswordField();
	private PasswordField tfKonfirmoFjalekalimin = new PasswordField();
	private TextField tfTelefoni = new TextField();
	private TextField tfAdresa = new TextField();
	private TextField tfQyteti = new TextField();
	private ToggleGroup tgGjinia = new ToggleGroup();
	//private RadioButton rbMashkull = new RadioButton("Mashkull");
	private RadioButton rbMashkull = I18N.getRadioButton("Mashkull");
	//private RadioButton rbFemer = new RadioButton("Femer");
	private RadioButton rbFemer = I18N.getRadioButton("Femer");
	
	private static Stage secondStage;
	private Kyqja kyqja = new Kyqja();
	
	private String css = "-fx-background-color:red;";

	
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException {
		GridPane gPane = new GridPane();
		gPane.setPadding(new Insets(20,50,50,50));
		gPane.setHgap(30);
		gPane.setVgap(10);
		

		Image imgSignup = new Image("images/signup.png");
		ImageView ivSignup = new ImageView(imgSignup);

		
//		Label lblEmri = new Label("Emri:");
//		Label lblMbiemri = new Label("Mbiemri:");
//		Label lblEmriPerdoruesit = new Label("Emri i perdoruesit:");
//		Label lblEmailAdresa = new Label("Email Adresa:");
//		Label lblFjalekalimi = new Label("Fjalekalimi:");
//		Label lblKonfirmoFjalekalimin = new Label("Konfirmo fjalekalimin:");		
//		
//		Label lblGjinia = new Label("Gjinia:");
//		Label lblTelefoni = new Label("Numri i telefonit:");
//		Label lblAdresa = new Label("Adresa:");
//		Label lblQyteti	= new Label("Qyteti:");
Label lblEmri = I18N.getLabel("Emri");				
		Label lblMbiemri = 	I18N.getLabel("Mbiemri");			
		Label lblEmriPerdoruesit = 	I18N.getLabel("EmriPerdoruesit");	
		Label lblEmailAdresa = 	I18N.getLabel("EmailAdresa");		
		Label lblFjalekalimi = 	I18N.getLabel("Fjalekalimi");		
		Label lblKonfirmoFjalekalimin = I18N.getLabel("KonfirmoFjalekalimin");

		Label lblGjinia = 	I18N.getLabel("Gjinia");			
		Label lblTelefoni = I18N.getLabel("Telefoni");			
		Label lblAdresa = 	I18N.getLabel("Adresa");			
		Label lblQyteti	= 	I18N.getLabel("Qyteti");			
		
		
		
		
		tfEmri.setPrefWidth(220);
		


		rbMashkull.setToggleGroup(tgGjinia);
		rbFemer.setToggleGroup(tgGjinia);
		

		
		//Button btnRegjistrohu = new Button("Regjistrohu");
		Button btnRegjistrohu = I18N.getButton("Regjistrohu");

		btnRegjistrohu.setOnAction(e->{
			if(validate()) {
				insertUser();
				try {
					kyqja.start(primaryStage);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnRegjistrohu.setOnKeyReleased(e->{
			if(e.getCode() == KeyCode.ENTER)
				if(validate())
					insertUser();
		});
		//Button btnAnulo = new Button("Anulo");
		Button btnAnulo = I18N.getButton("Anulo");
		btnAnulo.setOnAction(e->clearForm());
		btnRegjistrohu.setPrefWidth(105);
		btnAnulo.setPrefWidth(105);
		
		//Hyperlink hlKyqu = new Hyperlink("Kyqu");
		Hyperlink hlKyqu = I18N.getHyperlink("Kyqu");
		
		hlKyqu.setOnAction(e->{
			try {
				kyqja.start(primaryStage);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(I18N.getLabel("JeniTeRegjistruar"),hlKyqu);
		hBox.setAlignment(Pos.CENTER_LEFT);

		
		gPane.add(ivSignup, 1,0 );
		gPane.add(lblEmri, 0, 1);
		gPane.add(lblMbiemri, 0, 2);
		gPane.add(lblEmriPerdoruesit, 0, 3);
		gPane.add(lblEmailAdresa, 0, 4);
		gPane.add(lblFjalekalimi, 0, 5);
		gPane.add(lblKonfirmoFjalekalimin, 0, 6);
		//gPane.add(null, 0, 6);
		gPane.add(lblGjinia, 0, 7);
		gPane.add(lblTelefoni,0,8);
		gPane.add(lblAdresa, 0, 9);
		gPane.add(lblQyteti, 0, 10);
gPane.add(tfEmri, 1, 1);
		gPane.add(tfMbiemri, 1, 2);
		gPane.add(tfEmriPerdoruesit, 1, 3);
		gPane.add(tfEmailAdresa, 1, 4);
		gPane.add(tfFjalekalimi,1,5);
		gPane.add(tfKonfirmoFjalekalimin,1,6);
		//gPane.add(null, 1, 6);
		gPane.add(rbMashkull, 1, 7);
		gPane.add(rbFemer, 1, 7);
		gPane.add(tfTelefoni,1,8);
		gPane.add(tfAdresa, 1, 9);
		gPane.add(tfQyteti, 1, 10);
		gPane.add(btnRegjistrohu, 1, 11);
		gPane.add(btnAnulo, 1, 11);
		gPane.add(hBox, 1, 12);
		
		gPane.setHalignment(rbMashkull, HPos.LEFT);
		gPane.setHalignment(rbFemer, HPos.RIGHT);
		gPane.setHalignment(btnRegjistrohu, HPos.LEFT);
		gPane.setHalignment(btnAnulo, HPos.RIGHT);
		gPane.setHalignment(hlKyqu, HPos.CENTER);
		gPane.setHalignment(ivSignup, HPos.CENTER);
		
		
		ObservableList<String> allowedLanguage = FXCollections.observableArrayList();
		
		for(int i=0;i<I18N.getLanguages().size();i++) {
			allowedLanguage.add(I18N.getLanguages().get(i).getLanguage());
		}
languagesCbo.getItems().addAll(allowedLanguage);
		languagesCbo.setValue(I18N.getDefaultLocale().getLanguage());
		languagesCbo.setOnAction(e->switchLanguage());
		
		gPane.add(languagesCbo,1,13);
		gPane.setHalignment(languagesCbo, HPos.RIGHT);
		
		
		
		Scene scene = new Scene(gPane);
		primaryStage.setTitle("Regjistrimi");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
	}
	// INSERT USER TO DATABASE
	private void insertUser(){
		String query = "insert into users(firstName,lastName,gender,username,password,telephone,address,city,email) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pStatement = DatabaseConnection.getConnection().prepareStatement(query);
			
			String gjinia = null;
			if(rbMashkull.isSelected())
				gjinia = "M";
			else if(rbFemer.isSelected())
				gjinia = "F";
			
			String emri = tfEmri.getText();
			emri = emri.substring(0,1).toUpperCase() + emri.substring(1);
			
			String mbiemri = tfMbiemri.getText();
			mbiemri = mbiemri.substring(0,1).toUpperCase() + mbiemri.substring(1);
			
			pStatement.setString(1, emri);
			pStatement.setString(2, mbiemri);
			pStatement.setString(3, gjinia);
			pStatement.setString(4, tfEmriPerdoruesit.getText());
			pStatement.setString(5, tfFjalekalimi.getText());
			pStatement.setString(6, tfTelefoni.getText());
			pStatement.setString(7, tfAdresa.getText());
			pStatement.setString(8, tfQyteti.getText());
			pStatement.setString(9, tfEmailAdresa.getText());
			
			pStatement.executeUpdate();
			Alert infoAlert = new Alert(AlertType.INFORMATION);
			infoAlert.setTitle("INFO DIALOG");
			infoAlert.setHeaderText("Jeni regjistruar me sukses!");
			infoAlert.showAndWait();
			clearForm();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Something went wrong!Cannot insert student in database!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			clearForm();
		}
		
	}
	
	// CLEAR FORM
	private void clearForm() {
		tfEmri.setText("");
		tfMbiemri.setText("");
		tfEmriPerdoruesit.setText("");
		tfEmailAdresa.setText("");
		tfFjalekalimi.setText("");
		tfKonfirmoFjalekalimin.setText("");
		tfTelefoni.setText("");
		tfAdresa.setText("");
		tfQyteti.setText("");
		tgGjinia.selectToggle(null);
		
	}
	public boolean validate() {
		
		if(validoEmrin() && validoMbiemrin() && validoEmrinPerdoruesit()
				&& validoEmailin() && validoFjalekalimin() && validoTelefonin()
				&& validoAdresen() && validoQytetin() && validoGjinine())
			return true;
		else return false;
		
	}
	
	public boolean validoEmrin() {
		char[] charEmri = tfEmri.getText().toCharArray();
		int count = 0;
		for(int i =0;i<charEmri.length;i++)
			if(Character.isAlphabetic(charEmri[i])==false)				
				count++;

		if(count>0 || tfEmri.getText().length()<3) {
			tfEmri.setStyle("-fx-background-color:red;");
			return false;
		}
		else {
			tfEmri.setStyle("");
			return true;
		}
	}
public boolean validoMbiemrin() {
		char[] charMbiemri = tfMbiemri.getText().toCharArray();
		int count = 0;
		for(int i =0;i<charMbiemri.length;i++)
			if(Character.isAlphabetic(charMbiemri[i])==false) 
				count++;
		
		if(count>0 || tfMbiemri.getText().length()<4) {
			tfMbiemri.setStyle("-fx-background-color:red;");
			return false;
		}
		else {
			tfMbiemri.setStyle("");
			return true;
		}
	}
	
	public boolean validoEmrinPerdoruesit() {
		String userPattern = "^[a-z0-9_-]{6,20}$";
		
		String query = "select username from users where username = ?";
		try {
			PreparedStatement preparedStm = DatabaseConnection.getConnection().prepareStatement(query);
			preparedStm.setString(1, tfEmriPerdoruesit.getText());
			
			ResultSet rs = preparedStm.executeQuery();
			
			if(rs.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText("Ky emer '"+tfEmriPerdoruesit.getText()+"' eshte i regjistruar!\nJu lutem zgjedhni nje emer tjeter.");
				alert.showAndWait();
				return false;
			}
} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(tfEmriPerdoruesit.getText().matches(userPattern)) {
			tfEmriPerdoruesit.setStyle("");
			return true;
		}
		else {
			tfEmriPerdoruesit.setStyle("-fx-background-color:red;");
			return false;
		}
	}
	
	public boolean validoEmailin() {
		String emailPattern = "[a-zA-Z0-9._]{1,20}@[a-zA-Z]{1,10}[.]{1}[a-zA-Z]{2,3}";
		if(tfEmailAdresa.getText().matches(emailPattern)) {
			tfEmailAdresa.setStyle("");
			return true;
		}
		else {
			tfEmailAdresa.setStyle("-fx-background-color: red;");
			return false;
		}
		
	}
