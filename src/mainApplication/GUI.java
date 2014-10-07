

package mainApplication;

import java.util.ResourceBundle;

import buttonInput.Toolbar;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import parser.Parser;
import textInput.TextCommand;
import textOutput.ConsoleHistory;
//import javafx.geometry.Orientation;

public class GUI extends Application {


	/**
	 * Activates the necessary components for GUI
	 */

	private Stage myStage;
	private Group myRoot;
	private ResourceBundle myNumberResources;
	private int mySceneHeight;
	private int mySceneWidth;
	private ConsoleHistory myConsoleHistory;
//	private VBox vbox2;
	private VBox vbox1;
	private ScrollPane myScrollPane1;
	private GridPane myGridPane1;
//	private ScrollPane myScrollPane;
//	private GridPane myGridPane;

	private int myCounter = 0;
	
	private ComboBox languageCB;
	private ComboBox colourCB;

	public GUI(){
		myStage = new Stage();
		myRoot = new Group();
		Scene s = new Scene(myRoot, 1000, 700, Color.WHITE);
		 
		
		
		
		
		

		/*
		TextCommand exampleCommand = new TextCommand();
		String command = exampleCommand.readInput();
		Parser myParser = new Parser();
		String returnCommand = myParser.parse(command);
		 */

	}
	public static void main(String[] args){

		launch(args);
	}


	private Scene initiate(Group root){
		myNumberResources = ResourceBundle.getBundle("resources/constants/numbers");
		mySceneHeight = Integer.parseInt(myNumberResources.getString("Scene_height"));
		mySceneWidth = Integer.parseInt(myNumberResources.getString("Scene_width"));
		return new Scene(myRoot, mySceneWidth, mySceneHeight, Color.GREY);
	}



	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPrefWidth(mySceneWidth);
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);

	    
	    final TextArea myCommand = new TextArea();
	    myCommand.setPrefRowCount(3);
	    hbox.getChildren().add(myCommand);

	   Button run = new Button("Run");
	   run.setPrefSize(100, 20);

//	    myScrollPane.setContent(myGridPane);
	    myScrollPane1.setContent(myGridPane1);
	   run.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        System.out.println(myCommand.getText());
		        myConsoleHistory.update(myCommand.getText());
		        final Button button = new Button(myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	myCommand.setText(button.getText());
				    }	
				    });
		        Button button2 = button;
		        myGridPane1.add(button2, 0, myCounter);
//		        myGridPane.add(button, 0, myCounter);
		        
		        myCounter++;
//		        myScrollPane.setContent(myGridPane);
		        myScrollPane1.setContent(myGridPane1);
		        
		        myCommand.clear();
		    }
		});	   
	   	   hbox.getChildren().add(run);


		return hbox;
	}
	
	private HBox topHBox(){
		
		HBox topHB = new HBox();
		topHB.setPrefWidth(mySceneWidth);
		topHB.setSpacing(10);
		topHB.setStyle("-fx-background-color: yellow;");
		
		Button startButton = new Button("Start");
		startButton.setPrefSize(100, 20);
		startButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("start button clicked");
				System.out.println(languageCB.getValue());
				System.out.println(colourCB.getValue());
			}
			
		});
		
		
		Label colourLabel = new Label("Display Colour:");
		Label languageLabel = new Label("Language Pack:");
		
//		ObservableList<String> colourOptions = 
//				FXCollections.observableArrayList(
//						"Black",
//						"White",
//						"Yellow"
//						
//						);
//		final ComboBox colourCBox = new ComboBox(colourOptions);
//		
//		ObservableList<String> languageOptions = 
//				FXCollections.observableArrayList(						
//						"English",
//						"Spanish",
//						"Spanish"									
//						);
//		final ComboBox languageCBox = new ComboBox(languageOptions);
		
		colourCB = new ComboBox();
		colourCB.getItems().addAll("White", "Yellow", "Green");
		
		languageCB = new ComboBox();
		languageCB.getItems().addAll("English", "Spanish", "Chinese");
		
		
		
		topHB.getChildren().addAll(colourLabel, colourCB, languageLabel, languageCB, startButton);
		topHB.setPrefHeight(100);
		return topHB;
		
		
		
		
	}
	
	
	
	public VBox addVBox(String s) {
	    VBox vbox = new VBox();
	    vbox.setPrefHeight(mySceneHeight-200);
	    vbox.setPrefWidth(200);
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(10);

	    Button buttonCurrent = new Button(s);
	    buttonCurrent.setPrefSize(100, 20);
	    vbox.getChildren().add(buttonCurrent);

	    return vbox;
	}

	private Pane addTurtlePane(){
		Pane turtleCanvas = new Pane();
		turtleCanvas.setStyle("-fx-background-color: white");

		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[]{150.0, 150.0, 140.0, 170.0, 160.0, 170.0});
		triangle.setFill(Color.GREEN);
		turtleCanvas.getChildren().addAll(triangle);

		return turtleCanvas;
	}

	@Override
	public void start(Stage stage) throws Exception {
		myStage = new Stage();
		myRoot = new Group();
		myConsoleHistory = new ConsoleHistory();		
//		myScrollPane = new ScrollPane();
		myConsoleHistory.myScrollPane.setPrefHeight(400);
		myConsoleHistory.myScrollPane.setPrefWidth(200);
//		myGridPane = new GridPane();
		myGridPane1 = new GridPane();
		myScrollPane1 = new ScrollPane();
		myScrollPane1.setPrefHeight(400);
		
		Scene s = initiate(myRoot);
		BorderPane pane = setBorderPane(myRoot);
		vbox1 = addVBox("Variables");
		vbox1.getChildren().add(myScrollPane1);
//		vbox2 = addVBox("Command History");
//		vbox2.getChildren().add(myScrollPane);
		pane.setLeft(vbox1);
		pane.setRight(myConsoleHistory);
		
		
		
		
		
		
		myStage.setScene(s);
		myStage.show();	
	}

	private BorderPane setBorderPane(Group g){
		BorderPane pane = new BorderPane();
//		Pane topPane = new Pane();
//		topPane.setStyle("-fx-background-color: #225588;");
//		topPane.setPrefWidth(100);
//		topPane.getChildren().add(new Rectangle(0,0,100,100));
//		pane.setTop(topPane);
		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		pane.setBottom(hbox);
		pane.setCenter(addTurtlePane());

//		HBox hbox = addHBox();
//		hbox.setStyle("-fx-background-color: #336699;");
		//hbox.getChildren().add(new Label("Name:"));
		pane.setTop(topHBox());
		//pane.setBottom(addCommandHBox());
//		pane.setCenter(addTurtlePane());
		//hbox.getChildren().add(new Label("Name:"));
//		pane.setBottom(hbox);
		g.getChildren().add(pane);
		return pane;
	}

}
