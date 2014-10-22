package components;

import mainApplication.GUI;
import properties.Position;
import features.DisplayTurtle;
import features.Feature;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CenterPane extends Pane implements Feature{

	private ImageView turtleGraphic;
	private double turtleX;
	private double turtleY;
	private int turtleWidth = 26;
	private int turtleHeight = 50;
	private Label myLabel;
	
	public CenterPane(){
		super();
		this.setStyle("-fx-background-color: white");	
//		Image image = new Image("mainApplication/turtle.png");		
//		turtleView = new ImageView (image);
//		turtleView.setFitWidth(26);		
//		turtleView.setFitHeight(50);
//		turtleView.setLayoutX(275);
//		turtleView.setLayoutY(200);		
//		turtleX = 275;
//		turtleY = 200;
		
		DisplayTurtle firstTurtle = new DisplayTurtle();		
		firstTurtle.setTurtleID(0);		
		turtleGraphic = firstTurtle.makeNewTurtle();
		//GUI.myObjects.add(firstTurtle);
		myLabel = new Label("Turtle X: "+(275-turtleX)+"\nTurtle Y: "+(200-turtleY));
		this.getChildren().add(myLabel);
		this.getChildren().add(turtleGraphic);

	}
	@Override
	public void update() {
		
	}
	public void updateTurtlePosition(Position pos){
		double tempX = 275+pos.getPoint().getX();
		double tempY = 200-pos.getPoint().getY();
		drawLine(tempX, tempY);
//		turtleView.setLayoutX(turtleX);
//		turtleView.setLayoutY(turtleY);
		myLabel.setText("Turtle X: "+(275-turtleX)+"\nTurtle Y: "+(200-turtleY));
	}
	
	private void drawLine(double newX, double newY){
		Line line = new Line();
		line.setStroke(Color.BLACK);
		line.setStartX(turtleX+(turtleWidth/2));
		line.setStartY(turtleY+(turtleHeight));
		line.setEndX(newX+(turtleWidth/2));
		line.setEndY(newY+turtleHeight);
		this.getChildren().add(line);
		turtleX = newX;
		turtleY = newY;
	}
	

}
