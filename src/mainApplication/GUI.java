

package mainApplication;

import java.util.ResourceBundle;

import buttonInput.Toolbar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

public class GUI extends Application {
	
	
	/**
	 * Activates the necessary components for GUI
	 */

	private Stage myStage;
	private Group myRoot;
	private ResourceBundle myNumberResources;
	private int mySceneHeight;
	private int mySceneWidth;
	
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
		return new Scene(myRoot, mySceneHeight, mySceneWidth, Color.GREY);
	}
	
	private BorderPane setBorderPane(Group g){
		BorderPane pane = new BorderPane();
		
		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		hbox.getChildren().add(new Label("Name:"));
		pane.setTop(hbox);
		pane.setBottom(addCommandHBox());
		pane.setCenter(addTurtlePane());
		//hbox.getChildren().add(new Label("Name:"));
		//pane.setBottom(hbox);

		g.getChildren().add(pane);
		return pane;
	}
	
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPrefWidth(mySceneWidth);
	  //  hbox.setPrefHeight();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    
	    TextArea myCommand = new TextArea();
	    myCommand.setLayoutY(100);
	    hbox.getChildren().add(myCommand);
	  //  Button buttonCurrent = new Button("Current");
	   // buttonCurrent.setPrefSize(100, 20);

//	    Button buttonProjected = new Button("Projected");
	//    buttonProjected.setPrefSize(100, 20);
	  //  hbox.getChildren().addAll(buttonCurrent, buttonProjected);

	    return hbox;
	}
	public VBox addVBox(String s) {
	    VBox vbox = new VBox();
	    vbox.setPrefHeight(mySceneHeight-200);
	  //  hbox.setPrefHeight();
	    vbox.setPadding(new Insets(15, 12, 15, 12));
	    vbox.setSpacing(10);
	    vbox.setStyle("-fx-background-color: #333399;");

	    Button buttonCurrent = new Button(s);
	    buttonCurrent.setPrefSize(100, 20);
	    vbox.getChildren().add(buttonCurrent);

	    return vbox;
	}

	private Pane addTurtlePane(){
		Pane turtleCanvas = new Pane();
		turtleCanvas.setStyle("-fx-background-color: white");
		turtleCanvas.setPrefSize(300,300);
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
		Scene s = initiate(myRoot);
		BorderPane pane = setBorderPane(myRoot);
		VBox vcenter = addVBox("TurtleView");
		vcenter.setPrefWidth(50);
		VBox vbox = addVBox("Variables");
		VBox vbox2 = addVBox("Command History");
		vcenter.setStyle("-fx-background-color: #FFFFFF;");
		pane.setLeft(vbox);
		pane.setRight(vbox2);
		pane.setCenter(vcenter);
		myStage.setScene(s);
		myStage.show();	
	}
	}
