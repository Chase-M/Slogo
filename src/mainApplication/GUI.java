

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
	private VBox vbox2;
	private ScrollPane myScrollPane;
	//	public static final Orientation vert = VERTICAL;
	private FlowPane myFlowPane;
	private TilePane myTilePane;
	private StackPane myStackPane;
	private GridPane myGridPane;
	private int myCounter = 0;
	
	private ComboBox languageCB;
	private ComboBox colourCB;

	public GUI(){
		myStage = new Stage();
		myRoot = new Group();
		Scene s = new Scene(myRoot, 50, 50, Color.WHITE);






		/*
		TextCommand exampleCommand = new TextCommand();
		String command = exampleCommand.readInput();
		Parser myParser = new Parser();
		String returnCommand = myParser.parse(command);
		 */

	}
	public static void main(String[] args){
		//	Stage s = new Stage();
		//	start(s);
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
		//  hbox.setPrefHeight();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		// hbox.setStyle("-fx-background-color: #336699;");


		final TextArea myCommand = new TextArea();
		//myCommand.setLayoutY(50);
		myCommand.setPrefRowCount(3);
		hbox.getChildren().add(myCommand);
		//  Button buttonCurrent = new Button("Current");
		// buttonCurrent.setPrefSize(100, 20);

		Button buttonProjected = new Button("Run");
		buttonProjected.setPrefSize(100, 20);
		final int counter = 0;
		//  for(int i=0; i<50;i++){
		// 	myGridPane.add(new Button("test"), 0, i);	
		//}
		myScrollPane.setContent(myGridPane);
		buttonProjected.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println(myCommand.getText());
				myConsoleHistory.update(myCommand.getText());
				// myFlowPane.getChildren().add(new Label(myCommand.getText()));
				final Button button = new Button(myCommand.getText());
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {
						myCommand.setText(button.getText());
					}	
				});
				//  myFlowPane.getChildren().add(button);
				myGridPane.add(button, 0, myCounter);
				myCounter++;
				myScrollPane.setContent(myGridPane);
				/*       
		        myScrollPane.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
					  public void changed(ObservableValue<? extends Bounds> bounds, Bounds oldBounds, Bounds newBounds) {
					    myFlowPane.setPrefWidth(newBounds.getWidth());
					  }
					});
				 */

				myCommand.clear();
			}
		});	   
		hbox.getChildren().add(buttonProjected);

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
		return topHB;
		
		
		
		
	}
	
	
	
	public VBox addVBox(String s) {
		VBox vbox = new VBox();
		vbox.setPrefHeight(mySceneHeight-200);
		//  hbox.setPrefHeight();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(10);
		// vbox.setStyle("-fx-background-color: #333399;");

		Button buttonCurrent = new Button(s);
		buttonCurrent.setPrefSize(100, 20);
		vbox.getChildren().add(buttonCurrent);

		return vbox;
	}

	private Pane addTurtlePane(){
		Pane turtleCanvas = new Pane();
		turtleCanvas.setStyle("-fx-background-color: white");
		//turtleCanvas.setPrefWidth(900);
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[]{150.0, 150.0, 140.0, 170.0, 160.0, 170.0});
		//Rectangle rectangle = new Rectangle (100,100,Color.RED);
		//rectangle.relocate(0,0);
		turtleCanvas.getChildren().addAll(triangle);

		return turtleCanvas;
	}

	private HBox addCommandHBox(){
		Label commandLabel = new Label("Command: ");
		TextField commandTextField = new TextField();
		commandTextField.setPrefWidth(250);
		commandTextField.setPromptText("Enter your commands here");
		HBox commandHBox = new HBox();
		commandHBox.getChildren().addAll(commandLabel, commandTextField);
		commandHBox.setSpacing(10);

		return commandHBox;
	}


	@Override
	public void start(Stage stage) throws Exception {
		myStage = new Stage();
		myRoot = new Group();
		myConsoleHistory = new ConsoleHistory();		
		myFlowPane = new FlowPane(Orientation.VERTICAL);
		myScrollPane = new ScrollPane();
		myScrollPane.setPrefHeight(400);
		myStackPane = new StackPane();
		myGridPane = new GridPane();
		/*	myScrollPane.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
			  public void changed(ObservableValue<? extends Bounds> bounds, Bounds oldBounds, Bounds newBounds) {
			    myFlowPane.setPrefWidth(newBounds.getWidth());
			  }
			});
		 */		myTilePane = new TilePane(Orientation.VERTICAL);
		 //myFlowPane.
		 //myFlowPane.set
		 Scene s = initiate(myRoot);
		 BorderPane pane = setBorderPane(myRoot);
		 VBox vcenter = addVBox("TurtleView");
		 vcenter.setPrefWidth(50);
		 VBox vbox = addVBox("Variables");
		 vbox2 = addVBox("Command History");
		 vbox2.getChildren().addAll(myConsoleHistory.giveLabels());
		 vbox2.getChildren().add(myScrollPane);
		 vcenter.setStyle("-fx-background-color: #FFFFFF;");
		 pane.setLeft(vbox);
		 pane.setRight(vbox2);	
		 //pane.setCenter(vcenter);
		 myStage.setScene(s);
		 myStage.show();	
	}

	private BorderPane setBorderPane(Group g){
		BorderPane pane = new BorderPane();

		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		//hbox.getChildren().add(new Label("Name:"));
		pane.setTop(topHBox());
		//pane.setBottom(addCommandHBox());
		pane.setCenter(addTurtlePane());
		//hbox.getChildren().add(new Label("Name:"));
		pane.setBottom(hbox);
		g.getChildren().add(pane);
		return pane;
	}

}
