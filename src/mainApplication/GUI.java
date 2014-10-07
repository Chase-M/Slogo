

package mainApplication;

import java.util.ResourceBundle;

import buttonInput.Toolbar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
	
	private BorderPane setBorderPane(Group g){
		BorderPane pane = new BorderPane();
		
		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		//hbox.getChildren().add(new Label("Name:"));
		pane.setBottom(hbox);
		g.getChildren().add(pane);
		return pane;
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
	   buttonProjected.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        System.out.println(myCommand.getText());
		       // myCommand.clear();
		        myConsoleHistory.update(myCommand.getText());
		        myFlowPane.getChildren().add(new Label(myCommand.getText()));
		        myScrollPane.setContent(myFlowPane);
		        myCommand.clear();
		     //   vbox2.getChildren().add(new Circle(40,40,40,Color.WHEAT));
		    }
		});
	//   EventHandler<ActionEvent> onClick = new EventHandler<ActionEvent>();
	   
	   
	//   buttonProjected.addEventHandler(ActionEvent click, EventHandler onClick);
	   hbox.getChildren().add(buttonProjected);

	    return hbox;
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

	@Override
	public void start(Stage stage) throws Exception {
		myStage = new Stage();
		myRoot = new Group();
		myConsoleHistory = new ConsoleHistory();
		myScrollPane = new ScrollPane();
		myFlowPane = new FlowPane(Orientation.VERTICAL);
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
		
		
		
		
		
		
		pane.setCenter(vcenter);
		myStage.setScene(s);
		myStage.show();
		
		
	}
	}
