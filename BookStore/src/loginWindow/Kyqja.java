package loginWindow;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import regjistrimi.Regjistrimi;

public class Kyqja extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		
		GridPane gridPane = new GridPane();
		
		
		gridPane.setPadding(new Insets(50,50,50,50));
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		
		Label lblPerdoruesi = new Label("Perdoruesi");
		Label lblFjalekalimi = new Label("Fjalekalimi");
		Label lblRegjistrohu = new Label("Regjistrohu");
		Label lblBookstore = new Label("Book Store");
		lblBookstore.setFont(Font.font("Times New Roman", 30));
		
		TextField tfPerdoruesi = new TextField();
		PasswordField tfFjalekalimi = new PasswordField();
		tfPerdoruesi.setPrefWidth(300);
		
		
		CheckBox cbRuajFjalekalimin = new CheckBox("Mbaj mend fjalekalimin");
		
		Button btnKyqu = new Button("Kyqu");
		Button btnAnulo = new Button("Anulo");
		btnKyqu.setPrefWidth(145);
		btnAnulo.setPrefWidth(145);
		
		Hyperlink hlRegjistrohu = new Hyperlink("Regjistrohu");
		hlRegjistrohu.setOnAction(e->{
			Regjistrimi regjistrimi = new Regjistrimi();
			regjistrimi.start(primaryStage);
		});
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(new Label("Nuk jeni te regjistruar?"),hlRegjistrohu);
		hBox.setAlignment(Pos.CENTER_LEFT);
		
		gridPane.add(lblBookstore,1,0);
		gridPane.add(lblPerdoruesi,0,1);
		gridPane.add(tfPerdoruesi, 1, 1);
		gridPane.add(lblFjalekalimi, 0, 2);
		gridPane.add(tfFjalekalimi, 1, 2);
		gridPane.add(cbRuajFjalekalimin, 1, 3);
		gridPane.add(btnKyqu, 1, 4);
		gridPane.add(btnAnulo, 1, 4);
		gridPane.add(hBox, 1, 5);
		
		gridPane.setHalignment(btnAnulo, HPos.RIGHT);
		gridPane.setHalignment(hlRegjistrohu,HPos.CENTER);
		
		
		
		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("Kyqja");
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
