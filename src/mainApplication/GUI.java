

package mainApplication;

import actor.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import parser.Node;
import parser.Parser;
import buttonInput.Menubar;
import buttonInput.Toolbar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import textOutput.ConsoleHistory;
import textOutput.VariableDisplay;

public class GUI extends Pane implements Observer{


	/**
	 * Activates the necessary components for GUI
	 */

	private ResourceBundle myNumberResources;
	private int mySceneHeight;
	private int mySceneWidth;
	private ConsoleHistory myConsoleHistory;
	private VariableDisplay myVariableDisplay;
	private Toolbar myToolbar;
	private Menubar myMenubar;
	private Turtle myTurtle;
	private Pane turtleCanvas;
	private ImageView turtleView;
	private double currentX;
	private double currentY;
	private double newX;
	private double newY;
	private int turtleWidth;
	private int turtleHeight;

	public GUI(){
		// TODO move this
		myTurtle = new Turtle(0,0,Math.PI/2);
		myTurtle.addObserver(this);
	}

	 void initiate(){
		myNumberResources = ResourceBundle.getBundle("resources/constants/numbers");
		mySceneHeight = Integer.parseInt(myNumberResources.getString("Scene_height"));
		mySceneWidth = Integer.parseInt(myNumberResources.getString("Scene_width"));
		turtleWidth = Integer.parseInt(myNumberResources.getString("turtle_width"));
		turtleHeight = Integer.parseInt(myNumberResources.getString("turtle_height"));
		loadPanes();
	}

	private HBox addHBox() {
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

		        // TODO move this + don't only have one turtle + it shouldn't even be here
		        Parser myParser = new Parser();
				List<Node> list = myParser.parse(myCommand.getText());
				List<Turtle> tlist = new ArrayList<>();
				tlist.add(myTurtle);
				for(Node n: list){
					System.out.println(n.evaluate(tlist));
				}
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
	
	
	private Pane addTurtlePane(){
		turtleCanvas = new Pane();
		turtleCanvas.setStyle("-fx-background-color: white");	
		Image image = new Image("graphics/turtle.png");		
		turtleView = new ImageView (image);
		turtleView.setFitWidth(turtleWidth);		
		turtleView.setFitHeight(turtleHeight);
		turtleView.setLayoutX(275);
		turtleView.setLayoutY(200);	
		currentX = 275;
		currentY = 200;
		turtleCanvas.getChildren().add(turtleView);
		return turtleCanvas;
	}
	
	private void updateTurtlePosition(){		
		turtleView.setLayoutX(newX);
		turtleView.setLayoutY(newY);			
	}
	
	private void drawLine(){
		Line line = new Line();
		line.setStroke(Color.BLACK);
		line.setStartX(currentX+(turtleWidth/2));
		line.setStartY(currentY+(turtleHeight));
		line.setEndX(newX+(turtleWidth/2));
		line.setEndY(newY+turtleHeight);
		turtleCanvas.getChildren().add(line);
		currentX = newX;
		currentY = newY;
		
	}
	
	protected void loadPanes(){
		BorderPane pane = setBorderPane();		
		myConsoleHistory = new ConsoleHistory();		
		myConsoleHistory.myScrollPane.setPrefHeight(mySceneHeight-200);
		myConsoleHistory.myScrollPane.setPrefWidth(200);
		myVariableDisplay = new VariableDisplay();		
		myVariableDisplay.myScrollPane.setPrefHeight(mySceneHeight-200);
		myVariableDisplay.myScrollPane.setPrefWidth(200);
		pane.setLeft(myVariableDisplay);
		pane.setRight(myConsoleHistory);
	}

	private BorderPane setBorderPane(){
		BorderPane pane = new BorderPane();
		FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		myMenubar = new Menubar();
		myMenubar.setPrefWidth(mySceneWidth);
		myMenubar.setPrefHeight(33);
		myToolbar = new Toolbar();
		myToolbar.setPrefWidth(mySceneWidth);
		myToolbar.setPrefHeight(33);
		flowPane.getChildren().add(myMenubar);
		flowPane.getChildren().add(myToolbar);
		flowPane.getChildren().add(displayComponents.topHBox());
		flowPane.setPrefHeight(105);
		
		HBox hbox = addHBox();
		hbox.setStyle("-fx-background-color: #336699;");
		pane.setBottom(hbox);
		pane.setCenter(addTurtlePane());
		pane.setTop(flowPane);
		this.getChildren().add(pane);
		return pane;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO change this
		Point2D point = (Point2D)arg1;
		newX = currentX+point.getX();
		newY = currentY-point.getY();
		updateTurtlePosition();
		drawLine();	
	}

}
