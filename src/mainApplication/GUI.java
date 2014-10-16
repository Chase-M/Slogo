

package mainApplication;

import actor.Turtle;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import frontEnd.BottomPane;
import frontEnd.LeftPane;
import frontEnd.RightPane;
import frontEnd.TopPane;
import frontEnd.TurtleWindow;
import parser.Node;
import parser.Parser;
import properties.Position;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GUI extends Pane implements Observer{


	/**
	 * Activates the necessary components for GUI
	 */

	//private ResourceBundle myNumberResources;
	//private int mySceneHeight;
	//private int mySceneWidth;
	private RightPane myRightPane;
	private LeftPane myLeftPane;
	private Turtle myTurtle;
	private TurtleWindow myTurtleWindow;
	private double currentX;
	private double currentY;
	private int turtleWidth = 26;
	private int turtleHeight = 50;
	private Parser myParser;
	private BottomPane myBottomPane;
	private TopPane myTopPane;

	public GUI(){
		// TODO move this
		myTurtle = new Turtle(0,0,Math.PI/2);
		myTurtle.addObserver(this);
	}

	 void initiate(){
		//myNumberResources = ResourceBundle.getBundle("resources/constants/numbers");
		//mySceneHeight = Integer.parseInt(myNumberResources.getString("Scene_height"));
		//mySceneWidth = Integer.parseInt(myNumberResources.getString("Scene_width"));
		myParser = new Parser();
		loadPanes();
	}

	private Button createButton() {
	   Button run = new Button("Run");
	   run.setPrefSize(100, 20);

	   run.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

		        // TODO move this + don't only have one turtle + it shouldn't even be here
				List<Node> list = myParser.parse(myBottomPane.myCommand.getText());
				for(Node n: list){
					System.out.println(n.evaluate(myTurtle));
				}
		        final Button button = new Button(myBottomPane.myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	myBottomPane.myCommand.setText(button.getText());
				    }	
				    });
		        myRightPane.update(button);
		        myLeftPane.update(myBottomPane.myCommand.getText());		        
		        myBottomPane.myCommand.clear();
		    }
		});	   
		return run;
	}
	
	private Pane addTurtlePane(){
		myTurtleWindow = new TurtleWindow();	
		currentX = 275;
		currentY = 200;
		return myTurtleWindow;
	}
	
	private void drawLine(double newX, double newY){
		Line line = new Line();
		line.setStroke(Color.BLACK);
		line.setStartX(currentX+(turtleWidth/2));
		line.setStartY(currentY+(turtleHeight));
		line.setEndX(newX+(turtleWidth/2));
		line.setEndY(newY+turtleHeight);
		myTurtleWindow.getChildren().add(line);
		currentX = newX;
		currentY = newY;
		
	}
	
	private void loadPanes(){
		BorderPane pane = new BorderPane();
		myRightPane = new RightPane();		
		myLeftPane = new LeftPane();
		myTopPane = new TopPane();
		myBottomPane = new BottomPane();
		pane.setLeft(myLeftPane);
		pane.setRight(myRightPane);
		Button run = createButton();
		myBottomPane.updateButton(run);
		pane.setBottom(myBottomPane);
		pane.setCenter(addTurtlePane());
		pane.setTop(myTopPane);
		this.getChildren().add(pane);
	}
	@Override
	public void update(Observable obs, Object props) {
		// TODO change this
		//System.out.println("called");
		if(props instanceof Position){
			Position pos = (Position)props;
			double newX = 275+pos.getPoint().getX();
			double newY = 200-pos.getPoint().getY();
			myTurtleWindow.updateTurtlePosition(newX, newY);
			drawLine(newX, newY);
		}
	}
}
