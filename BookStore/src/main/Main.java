package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	TextField tfKerko = new TextField();
	public static StackPane sellPane;
	public static HBox hbBooks;
	@Override
	public void start(Stage primaryStage) {
		User user = new User(UserInfo.USERNAME);
		
        Menu helpMenu = new Menu("Help") ;

        MenuItem aboutHelpItem = new MenuItem("About"); 
        helpMenu.getItems().add(aboutHelpItem); 
        
        aboutHelpItem.setOnAction(e -> {
        	Help.about();
        });
        
        
        
  
        MenuBar mb = new MenuBar(); 
  
        mb.getMenus().addAll(helpMenu); 
        
		
		VBox vBoxMain = new VBox(20);
		
		String btnStyle = "-fx-background-color:rgb(228,0,70);";
		Font btnFont = Font.font("Times New Roman",FontWeight.BOLD,15);
		
		HBox hBox1 = new HBox(130);
		hBox1.setPadding(new Insets(25,25,25,25));
		hBox1.setStyle("-fx-background-color:rgb(228,0,70);");
		
		
		Label lblBookstore = new Label("BookStore");
		lblBookstore.setFont(Font.font("Sans-serif",FontWeight.BOLD,20));
		lblBookstore.setTextFill(Color.WHITE);
		
		tfKerko.setPrefWidth(450);
		tfKerko.setPrefHeight(35);
		
		Button btnKerko = new Button("Kerko");
		btnKerko.setStyle("-fx-background-color:rgb(51,51,51);");
		btnKerko.setTextFill(Color.WHITE);
		btnKerko.setPrefSize(100, 35);
		btnKerko.setFont(btnFont);
		
		btnKerko.setCursor(Cursor.HAND);
		
		
		
		btnKerko.setOnAction(e->{
			kerko();
		});
		
		tfKerko.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER)
				kerko();
		});

		
	
		
		Button btnShitjet = new Button("Shitjet");
		btnShitjet.setStyle(btnStyle);
		btnShitjet.setTextFill(Color.WHITE);
		btnShitjet.setPrefSize(100, 30);
		btnShitjet.setFont(btnFont);
		
		btnShitjet.setOnMouseEntered(e->{
			btnShitjet.setCursor(Cursor.HAND);
		});
		
		btnShitjet.setOnAction(e->{
			Stage shitjetStage = new Stage();
			
			TableView tvShitjet = new TableView();
			tvShitjet.setPadding(new Insets(15,15,15,15));
			
			TableColumn<String, Book> column1= new TableColumn<>("Book Id");
			column1.setCellValueFactory(new PropertyValueFactory("bookID"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column2= new TableColumn<>("Title");
			column1.setCellValueFactory(new PropertyValueFactory("title"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column3= new TableColumn<>("Author");
			column1.setCellValueFactory(new PropertyValueFactory("author"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column4= new TableColumn<>("Genre");
			column1.setCellValueFactory(new PropertyValueFactory("genre"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column5= new TableColumn<>("Publication Year");
			column1.setCellValueFactory(new PropertyValueFactory("publicationYear"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column6= new TableColumn<>("Price");
			column1.setCellValueFactory(new PropertyValueFactory("price"));
			column1.setPrefWidth(60);
			
			tvShitjet.getColumns().addAll(column1,column2,column3,column4,column5,column6);
			
			String shitjetQuery = "SELECT * FROM Book B WHERE B.bookID IN (SELECT S.bookID FROM Sales S)";
			List<Book> shitjetBooks = Book.getBooks(shitjetQuery);
			ObservableList<Book> shitjetBookList = FXCollections.observableArrayList();
			
			for(int i =0;i<shitjetBooks.size();i++) {
				shitjetBookList.add(shitjetBooks.get(i));
			}
			
			tvShitjet.setItems(shitjetBookList);
			
			Scene scene = new Scene(tvShitjet);
			shitjetStage.setTitle("Librat e shitur");
			shitjetStage.setScene(scene);
			shitjetStage.show();
		});


		
		Button btnBlerjet = new Button("Blerjet");
		btnBlerjet.setStyle(btnStyle);
		btnBlerjet.setTextFill(Color.WHITE);
		btnBlerjet.setPrefSize(100, 30);
		btnBlerjet.setFont(btnFont);

		btnBlerjet.setOnMouseEntered(e->{
			btnBlerjet.setCursor(Cursor.HAND);
		});
		
		btnBlerjet.setOnAction(e->{
			Stage blerjetStage = new Stage();
			
			TableView tvBlerjet = new TableView();
			tvBlerjet.setPadding(new Insets(15,15,15,15));
			
			TableColumn<String, Book> column1= new TableColumn<>("Book Id");
			column1.setCellValueFactory(new PropertyValueFactory("bookID"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column2= new TableColumn<>("Title");
			column1.setCellValueFactory(new PropertyValueFactory("title"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column3= new TableColumn<>("Author");
			column1.setCellValueFactory(new PropertyValueFactory("author"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column4= new TableColumn<>("Genre");
			column1.setCellValueFactory(new PropertyValueFactory("genre"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column5= new TableColumn<>("Publication Year");
			column1.setCellValueFactory(new PropertyValueFactory("publicationYear"));
			column1.setPrefWidth(60);
			
			TableColumn<String, Book> column6= new TableColumn<>("Price");
			column1.setCellValueFactory(new PropertyValueFactory("price"));
			column1.setPrefWidth(60);
			
			tvBlerjet.getColumns().addAll(column1,column2,column3,column4,column5,column6);
			
			String blerjetQuery = "SELECT * FROM Book B WHERE B.bookID IN (SELECT P.bookID FROM Purchases P)";
			List<Book> blerjetBooks = Book.getBooks(blerjetQuery);
			ObservableList<Book> blerjetBooksList = FXCollections.observableArrayList();
			
			for(int i =0;i<blerjetBooks.size();i++) {
				blerjetBooksList.add(blerjetBooks.get(i));
			}
			
			tvBlerjet.setItems(blerjetBooksList);
			
			Scene scene = new Scene(tvBlerjet);
			blerjetStage.setTitle("Librat e blere");
			blerjetStage.setScene(scene);
			blerjetStage.show();
		});

		
		Button btnShkyqu = new Button("Shkyqu");
		btnShkyqu.setStyle(btnStyle);
		btnShkyqu.setTextFill(Color.WHITE);
		btnShkyqu.setPrefSize(100, 30);
		btnShkyqu.setFont(btnFont);
		
		btnShkyqu.setOnMouseClicked(e->{
			UserInfo.USERNAME="";
			Kyqja kyqja = new Kyqja();
			try {
				kyqja.start(primaryStage);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btnShkyqu.setOnMouseEntered(e->{
			btnShkyqu.setCursor(Cursor.HAND);
		});
		Label lb = new Label(UserInfo.USERNAME);
		lb.setStyle("-fx-text-fill:black;");
		lb.setFont(Font.font("Times new Roman",FontWeight.BOLD,20));
		HBox hBoxButonat = new HBox(5);
		hBoxButonat.getChildren().addAll(btnShitjet,btnBlerjet,btnShkyqu,lb);
		hBoxButonat.setStyle("-fx-background-color:rgb(228,0,70);");
		
		HBox hBoxKerko = new HBox();
		hBoxKerko.getChildren().addAll(tfKerko,btnKerko);
		
		hBox1.getChildren().addAll(lblBookstore,hBoxKerko, hBoxButonat);				
		
		vBoxMain.getChildren().addAll(mb,hBox1);
		
		// Pjesa nen header
		HBox hbTimeline = new HBox(30);
		
		VBox vbKategorite = new VBox(); //per hiperlinkat
		vbKategorite.setPadding(new Insets(20,60,20,60));
		
		Label lblZgjedh = new Label("Kategorite");
		
		
		Hyperlink hpBook1 = new Hyperlink("Poezi");
		Hyperlink hpBook2 = new Hyperlink("Romane");
		Hyperlink hpBook3 = new Hyperlink("Shkencor");
		Hyperlink hpBook4 = new Hyperlink("Per Femij");
		Hyperlink hpBook5 = new Hyperlink("Biografik");
		Hyperlink hpBook6 = new Hyperlink("Per nxenes");
		Hyperlink hpBook7 = new Hyperlink("Komedi");
		Hyperlink hpBook8 = new Hyperlink("Fantazi");
		
		hpBook1.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Poezi'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Poezi nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();

			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		
		hpBook2.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Romane'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Roman nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();

			}
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
						
		});
		
		hpBook3.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Shkencor'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Shkencore nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		
		hpBook4.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Per Femij'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Per Femij nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		hpBook5.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Biografik'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Biografik nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		hpBook6.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Per Nxenes'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Per Nxenes nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		
		hpBook7.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Komedi'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Komedi nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		
		
		hpBook8.setOnAction(e->{
			Stage poeziStage = new Stage();
			FlowPane poeziPane = new FlowPane();
			Scene scene = new Scene(poeziPane);
			
			poeziPane.setOrientation(Orientation.HORIZONTAL);
			
			String query1 = "SELECT * FROM book WHERE genre = 'Fantazi'";
			List<Book> books = Book.getBooks(query1);
			BookPane[] bookPane = new BookPane[books.size()];
			if(books.isEmpty()) {
								
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Libri nuk eshte gjetur");
				alert.setContentText("Asnje liber Fantazi nuk u gjend");
				alert.showAndWait();				
			}
			else {
				for(int i=0;i<books.size();i++) {
					bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
					poeziPane.getChildren().add(bookPane[i]);
				}
				poeziStage.show();
			}
			
			poeziStage.setMaximized(true);
			poeziStage.setScene(scene);
			
		});
		

		
		
		
		lblZgjedh.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 25));
		hpBook1.setFont(Font.font("monospace",17));
		hpBook2.setFont(Font.font("monospace",17));
		hpBook3.setFont(Font.font("monospace",17));
		hpBook4.setFont(Font.font("monospace",17));
		hpBook5.setFont(Font.font("monospace",17));
		hpBook6.setFont(Font.font("monospace",17));
		hpBook7.setFont(Font.font("monospace",17));
		hpBook8.setFont(Font.font("monospace",17));

				
		vbKategorite.getChildren().addAll(lblZgjedh,hpBook1,hpBook2,hpBook3,
				hpBook4,hpBook5,hpBook6,hpBook7,hpBook8);
		
		vbKategorite.setStyle(" -fx-background-color: linear-gradient(to top left, #cb2d3e, #ef473a);-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"); //me gjet naj ngjyr tmir
		hpBook1.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook2.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook3.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook4.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook5.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook6.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook7.setStyle("-fx-text-fill: #f7cfd7;");
		hpBook8.setStyle("-fx-text-fill: #f7cfd7;");

		lblZgjedh.setStyle("-fx-text-fill: #d39e17;");
		//lblZgjedh.setPadding(new Insets(10, 10, 20, 10));
			
		
		//vbKategorite.setMaxWidth(250);
		vbKategorite.setAlignment(Pos.CENTER);
		
		//  vbKategorite.setSpacing(-15);
		//	VBox.setMargin(vbKategorite, new Insets(20,20,10,40));
		
		// slideshow
		//Image imgTimeline = new Image("images/timeline.jpg");

		Image imgTimeline = new Image("images/red.jpg");

		ImageView ivTimeline = new ImageView(imgTimeline);
		ivTimeline.setFitWidth(1000);
		ivTimeline.setFitHeight(350);
		ivTimeline.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		
		
		hbTimeline.getChildren().add(vbKategorite);
		hbTimeline.getChildren().add(ivTimeline);
		//hbTimeline.setPadding(new Insets(20,20,20,30));
		
		vBoxMain.getChildren().add(hbTimeline);
		
		// books
		hbBooks = new HBox(15);
		getBooks();
//		List<Book> books = Book.getBooks();
//		BookPane[] bookPane = new BookPane[5];
//		for(int i=0;i<5;i++) {
//			bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
//			hbBooks.getChildren().add(bookPane[i]);
//		}
		
		sellPane = new StackPane();
		sellPane.setStyle("-fx-background-color:white;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		
		
		ImageView ivPlus = new ImageView(new Image("images/PLUS.png"));
		ivPlus.setFitHeight(67);
		ivPlus.setFitWidth(69);
		
		
		Button btnSell = new Button("",ivPlus);
		btnSell.setStyle("-fx-background-color:white;");
		
		btnSell.setOnMouseEntered(e->{
			btnSell.setCursor(Cursor.HAND);
		});
		
		btnSell.setOnAction(e->{
			Stage sellStage = new Stage();
			
			GridPane gridSellPane = new GridPane();
			gridSellPane.setPadding(new Insets(15,15,15,15));
			gridSellPane.setVgap(5);
			gridSellPane.setHgap(10);
			gridSellPane.setStyle("-fx-background-color: linear-gradient(to top left, #FAE3E3, #ef473a);-fx-effect: dropshadow(three-pass-box, rgba(0,0,10,0.8), 10, 0, 0, 0);");

			
			
			Label lblSellTitulli = new Label("Titulli: ");
			Label lblSellAutori = new Label("Autori: ");
			Label lblSellKategoria = new Label("Kategoria: ");
			Label lblSellViti = new Label("Viti: ");
			Label lblSellCmimi = new Label("Cmimi: ");
			
			TextField tfSellTitulli = new TextField();
			TextField tfSellAutori = new TextField();
			TextField tfSellKategoria = new TextField();
			TextField tfSellViti = new TextField();
			TextField tfSellCmimi = new TextField();
			
			Button btnSell1 = new Button("Publiko librin");
			btnSell1.setStyle("-fx-background-color: \r\n" + 
					"        linear-gradient(#ffd65b, #e68400),\r\n" + 
					"        linear-gradient(#ffef84, #f2ba44),\r\n" + 
					"        linear-gradient(#ffea6a, #efaa22),\r\n" + 
					"        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n" + 
					"        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n" + 
					"    -fx-background-radius: 30;\r\n" + 
					"    -fx-background-insets: 0,1,2,3,0;\r\n" + 
					"    -fx-text-fill: #654b00;\r\n" + 
					"    -fx-font-weight: bold;\r\n" + 
					"    -fx-font-size: 14px;\r\n" + 
					"    -fx-padding: 10 20 10 20;");
			btnSell1.setCursor(Cursor.HAND);
			btnSell1.setOnAction(e1->{
				if(Book.insertBook(tfSellTitulli.getText(), tfSellAutori.getText(), tfSellKategoria.getText(), tfSellViti.getText(), Double.parseDouble(tfSellCmimi.getText()))) {
					String bookIdQuery = "SELECT bookID FROM book where bookID = (SELECT MAX(bookID) from book);";
					int bookId=0;
					try {
					Statement bookIdStm = DatabaseConnection.getConnection().createStatement();
					ResultSet resultId = bookIdStm.executeQuery(bookIdQuery);
					if(resultId.next())
						bookId=resultId.getInt("bookID");
					}
					catch(SQLException ex) {
						ex.printStackTrace();
					}
					Book.insertIntoUser_Book(user.getId(), bookId);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("Publikimi perfundoi me sukses!");
					alert.setContentText("Libri juaj eshte ne shitje!");
					alert.showAndWait();
					sellStage.close();
					hbBooks.getChildren().clear();
					getBooks();
					hbBooks.getChildren().add(sellPane);					
				}
				else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Publikimi NUK perfundoi me sukses!");
					alert.setContentText("Libri juaj NUK eshte ne shitje!");
					alert.showAndWait();
				}
			});
			
			gridSellPane.addRow(0, lblSellTitulli,tfSellTitulli);
			gridSellPane.addRow(1, lblSellAutori,tfSellAutori);
			gridSellPane.addRow(2, lblSellKategoria,tfSellKategoria);
			gridSellPane.addRow(3, lblSellViti,tfSellViti);
			gridSellPane.addRow(4, lblSellCmimi,tfSellCmimi);
			gridSellPane.add(btnSell1,1,5);
			
			
			Scene sellScene = new Scene(gridSellPane);
			
			sellStage.setScene(sellScene);
			sellStage.show();
			
		});
		
		
		sellPane.getChildren().add(btnSell);
		sellPane.setPrefWidth(400);
		
		hbBooks.getChildren().add(sellPane);
		
		
		vBoxMain.getChildren().add(hbBooks);
		
		vBoxMain.setPadding(new Insets(10,15,10,15));
		Scene scene = new Scene(vBoxMain);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BookStore");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void getBooks() {
		List<Book> books = Book.getBooks();
		BookPane[] bookPane = new BookPane[5];
		for(int i=0;i<5;i++) {
			bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
			hbBooks.getChildren().add(bookPane[i]);
		}
	}
	
	public void kerko() {
		if(tfKerko.getText().length()>4) {
			
		Stage searchStage = new Stage();
		HBox hbBooksSearched = new HBox(15);

		Scene bookSearchedScene = new Scene(hbBooksSearched);
		searchStage.setScene(bookSearchedScene);
		
		String strBook = tfKerko.getText();
		String query = "SELECT * FROM Book WHERE title LIKE '%"+strBook+"%'";
		
		hbBooksSearched.setPadding(new Insets(15,15,15,15));
		
		List<Book> books = Book.getBooks(query);
		BookPane[] bookPane = new BookPane[books.size()];
		
		if(books.isEmpty()) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Libri nuk eshte gjetur!");
			alert.setContentText("Ky liber nuk ekziston!");
			alert.showAndWait();

		}
		else {
		for(int i=0;i<bookPane.length;i++) {
			bookPane[i] = new BookPane(books.get(i).getBookId(),books.get(i).getTitle(),books.get(i).getAuthor(),books.get(i).getGenre(),books.get(i).getPublicationYear(),books.get(i).getPrice());
			hbBooksSearched.getChildren().add(bookPane[i]);
			}
		searchStage.show();

		}

		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
