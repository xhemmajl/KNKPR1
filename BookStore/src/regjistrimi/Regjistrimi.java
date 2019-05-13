package regjistrimi;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import loginWindow.Kyqja;

public class Regjistrimi extends Application{
	@Override
	public void start(Stage primaryStage) {
		BorderPane bPane = new BorderPane();
		StackPane sPane = new StackPane();
		
		GridPane gPane = new GridPane();
		gPane.setPadding(new Insets(50,50,50,50));
		gPane.setHgap(20);
		gPane.setVgap(20);
		
		bPane.setCenter(gPane);
		bPane.setTop(sPane);
		
		Label lblRegjistrimi = new Label("Regjistrimi i perdoruesve te rinj");
		lblRegjistrimi.setFont(Font.font("Times New Roman",30));
		lblRegjistrimi.setPadding(new Insets(15,0,0,0));
		
		Label lblEmri = new Label("Emri:");
		Label lblMbiemri = new Label("Mbiemri:");
		Label lblEmriPerdoruesit = new Label("Emri i perdoruesit:");
		Label lblEmailAdresa = new Label("Email Adresa:");
		Label lblFjalekalimi = new Label("Fjalekalimi:");
		Label lblKonfirmoFjalekalimin = new Label("Konfirmo fjalekalimin:");
		
		sPane.getChildren().add(lblRegjistrimi);
		
		
		Label lblGjinia = new Label("Gjinia:");
		Label lblTelefoni = new Label("Numri i telefonit:");
		Label lblAdresa = new Label("Adresa:");
		Label lblQyteti	= new Label("Qyteti:");
		
		
		TextField tfEmri = new TextField();
		TextField tfMbiemri = new TextField();
		TextField tfEmriPerdoruesit = new TextField();
		TextField tfEmailAdresa = new TextField();
		PasswordField tfFjalekalimi = new PasswordField();
		PasswordField tfKonfirmoFjalekalimin = new PasswordField();
		
		tfEmri.setPrefWidth(220);
		
		TextField tfTelefoni = new TextField();
		TextField tfAdresa = new TextField();
		TextField tfQyteti = new TextField();
		
		
		RadioButton rbMashkull = new RadioButton("Mashkull");
		RadioButton rbFemer = new RadioButton("Femer");
		ToggleGroup tgGjinia = new ToggleGroup();
		rbMashkull.setToggleGroup(tgGjinia);
		rbFemer.setToggleGroup(tgGjinia);
		
		Button btnRegjistrohu = new Button("Regjistrohu");
		Button btnAnulo = new Button("Anulo");
		btnRegjistrohu.setPrefWidth(105);
		btnAnulo.setPrefWidth(105);
		
		Hyperlink hlKyqu = new Hyperlink("Kyqu");
		hlKyqu.setOnAction(e->{
			Kyqja kyqja = new Kyqja();
			kyqja.start(primaryStage);
		});
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(new Label("Jeni te regjistruar?"),hlKyqu);
		hBox.setAlignment(Pos.CENTER_LEFT);
		
		gPane.add(lblEmri, 0, 0);
		gPane.add(lblMbiemri, 0, 1);
		gPane.add(lblEmriPerdoruesit, 0, 2);
		gPane.add(lblEmailAdresa, 0, 3);
		gPane.add(lblFjalekalimi, 0, 4);
		gPane.add(lblKonfirmoFjalekalimin, 0, 5);
		//gPane.add(null, 0, 6);
		gPane.add(lblGjinia, 0, 7);
		gPane.add(lblTelefoni,0,8);
		gPane.add(lblAdresa, 0, 9);
		gPane.add(lblQyteti, 0, 10);
		
		
		gPane.add(tfEmri, 1, 0);
		gPane.add(tfMbiemri, 1, 1);
		gPane.add(tfEmriPerdoruesit, 1, 2);
		gPane.add(tfEmailAdresa, 1, 3);
		gPane.add(tfFjalekalimi,1,4);
		gPane.add(tfKonfirmoFjalekalimin,1,5);
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
		
		
		Scene scene = new Scene(bPane);
		primaryStage.setTitle("Regjistrimi");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
	Application.launch(args);
	}
}
