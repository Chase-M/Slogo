package features;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class DisplayTurtle {
	
	//private ImageView turtleGraphic;
	private static double turtleX;
	private static double turtleY;
	private static int turtleWidth;
	private static int turtleHeight;
	private static ImageView turtleGraphic;
	private Pen myPen;
	private double turtleAngle;
	
	private List<Line> drawnLines; //is this necessary?
	
	private int turtleID;
	

	public DisplayTurtle(){
		turtleWidth = 26;
		turtleHeight = 50;
	}
	
	public static ImageView makeNewTurtle(){
		Image image = new Image("features/turtle.png");	
		
		turtleGraphic = new ImageView (image);
		turtleGraphic.setFitWidth(26);		
		turtleGraphic.setFitHeight(50);
		turtleGraphic.setLayoutX(275);
		turtleGraphic.setLayoutY(200);
		turtleX = 275;
		turtleY = 200;
		
		return turtleGraphic;
		
	}
	
	public void setTurtleID(int ID){
		turtleID = ID;	
	}
	
	public void updateTurtlePosition(double newX, double newY){
		
		turtleGraphic.setLayoutX(newX);
		turtleGraphic.setLayoutX(newY);
		myPen.drawLine(newX, newY);
		updateTurtleAngle(newX,newY);
		//TODO: add this to be displayed. 
		
	}
	
	
		
	//this method is for the setxy command. 
	public void updateTurtleAngle(double newX, double newY){
		
		
		Double angle = new Double(Math.atan((newY-turtleY)/(newX-turtleX)));
		//probably needs some sort of addition/subtraction with current.
		turtleGraphic.setRotate(angle);

		turtleX = newX;
		turtleY = newY;	
	}
	
	public void newTurtleAngle(double num){
		
		//radians? what is default. lefts and rights.
		turtleGraphic.setRotate(num);		
	}
	
	
	
	
}
