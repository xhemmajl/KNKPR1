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
