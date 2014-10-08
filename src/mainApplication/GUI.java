

package mainApplication;

import java.util.ResourceBundle;

import buttonInput.Menubar;
import buttonInput.Toolbar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import textOutput.ConsoleHistory;
import textOutput.VariableDisplay;

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
	private VariableDisplay myVariableDisplay;
//	private Toolbar myToolbar;
	private Menubar myMenubar;
	
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

	   run.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        System.out.println(myCommand.getText());
		        final Button button = new Button(myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	myCommand.setText(button.getText());
				    }	
				    });
		        myConsoleHistory.update(button);
		        myVariableDisplay.update(myCommand.getText());		        
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
		
		colourCB = new ComboBox();
		colourCB.getItems().addAll("White", "Yellow", "Green");
		
		languageCB = new ComboBox();
		languageCB.getItems().addAll("English", "Spanish", "Chinese");
		
	
		topHB.getChildren().addAll(colourLabel, colourCB, languageLabel, languageCB, startButton);
		topHB.setPrefHeight(34);
		return topHB;
		
		
		
		
	}
	
	
/*	
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
*/
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
		Scene s = initiate(myRoot);
		BorderPane pane = setBorderPane(myRoot);
		
		myConsoleHistory = new ConsoleHistory();		
		myConsoleHistory.myScrollPane.setPrefHeight(mySceneHeight-200);
		myConsoleHistory.myScrollPane.setPrefWidth(200);
		myVariableDisplay = new VariableDisplay();		
		myVariableDisplay.myScrollPane.setPrefHeight(mySceneHeight-200);
		myVariableDisplay.myScrollPane.setPrefWidth(200);
		pane.setLeft(myVariableDisplay);
		pane.setRight(myConsoleHistory);
		
		myStage.setScene(s);
		myStage.show();	
	}

	private BorderPane setBorderPane(Group g){
		BorderPane pane = new BorderPane();
		FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		myMenubar = new Menubar();
		myMenubar.setPrefWidth(mySceneWidth);
		myMenubar.setPrefHeight(33);
		Toolbar myToolbar = new Toolbar();
		myToolbar.setPrefWidth(mySceneWidth);
		myToolbar.setPrefHeight(33);
		flowPane.getChildren().add(myMenubar);
		flowPane.getChildren().add(myToolbar);
		flowPane.getChildren().add(topHBox());
		flowPane.setPrefHeight(105);
		
//		Pane topPane = new Pane();
//		topPane.setStyle("-fx-background-color: #225588;");
//		topPane.setPrefWidth(100);
//		topPane.getChildren().add(new Rectangle(0,0,100,100));
//		pane.setTop(topPane);
		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		pane.setBottom(hbox);
		pane.setCenter(addTurtlePane());

		pane.setTop(flowPane);
		g.getChildren().add(pane);
		return pane;
	}

}
