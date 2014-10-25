package features;


import java.util.ArrayList;
import java.util.List;

import components.CenterPane;
import properties.Position;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class DisplayTurtle {
	
	//private ImageView turtleGraphic;
	private static double turtleX;
	private static double turtleY;
	private static double turtleAngle;
	private static int turtleWidth;
	private static int turtleHeight;
	private static ImageView turtleGraphic;
	private Pen myPen;
	private CenterPane myCenterPane;
	
	public Line myLine; 
	
	private int turtleID;
	public ImageView myImage;
	

	public DisplayTurtle(CenterPane pane){
		turtleWidth = 26;
		turtleHeight = 50;
		turtleX = 0;
		turtleY = 0;
		turtleAngle = 90;

		Image image = new Image("features/turtle.png");		
		myImage = new ImageView (image);
		myImage.setFitWidth(26);		
		myImage.setFitHeight(50);
		//myLines = new ArrayList<Line>();
		
		updateImage(turtleX, turtleY, turtleAngle);
		myPen = new Pen();
		myCenterPane = pane;
		
		

	}
	
	public void setTurtleID(int ID){
		turtleID = ID;	
	}
	public void updatePosition(Position pos){
		turtleX = pos.getX();
		turtleY = pos.getY();
		turtleAngle = pos.getAngle();		
		System.out.println("angle:" + turtleAngle);
		updateImage(turtleX, turtleY, turtleAngle);	
		updateLine(turtleX, turtleY);		
	}
	public void updateImage(double turtleX2, double turtleY2, double turtleAngle2){
		myImage.setLayoutX(275+turtleX2);
		myImage.setLayoutY(200-turtleY2);
		myImage.setRotate(90-Math.toDegrees(turtleAngle2));
	}
	
	private void updateLine(double x, double y){
		myLine = myPen.drawLine(turtleX, turtleY);
		myCenterPane.getChildren().add(myLine);		
	}
			
	
	
	
	
}
