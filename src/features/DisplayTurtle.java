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
	private static double turtleWidth;
	private static double turtleHeight;
	private static ImageView turtleGraphic;
	public Pen myPen;
	private CenterPane myCenterPane;
	public boolean isTurtleShowing;
	private boolean penDown;
	private List linesDrawn;
	private double middleX;
	private double middleY;
	
	public Line myLine; 
	
	private int turtleID;
	public ImageView myImage;
	

	public DisplayTurtle(CenterPane pane){
		turtleWidth = 26;
		turtleHeight = 50;
		turtleX = 0;
		turtleY = 0;
		turtleAngle = 90;
		middleX = 275;
		middleY = 200;
		penDown =true;
		Image image = new Image("features/turtle.png");		
		myImage = new ImageView (image);
		myImage.setFitWidth(turtleWidth);		
		myImage.setFitHeight(turtleHeight);	
		updateImage(turtleX, turtleY, turtleAngle);
		myPen = new Pen();
		myCenterPane = pane;
		linesDrawn = new ArrayList<Line>();
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
	
	public void updateTurtleShow(boolean show){	
		System.out.println("show:" +show);		
		isTurtleShowing = show;		
		if(show == false){
			myCenterPane.getChildren().remove(myImage);
			System.out.println("removed");
		}
		
	}
	
	public void updateImage(double turtleX2, double turtleY2, double turtleAngle2){
		myImage.setLayoutX(middleX+turtleX2);
		myImage.setLayoutY(middleY-turtleY2);
		myImage.setRotate(90-Math.toDegrees(turtleAngle2));
	}
	
	private void updateLine(double x, double y){
		myLine = myPen.drawLine(turtleX, turtleY, turtleWidth, turtleHeight);
		if(penDown == true){
		myCenterPane.getChildren().add(myLine);	
		linesDrawn.add(myLine);
		System.out.println("linesDrawn Size:" +linesDrawn.size());
		}
	}
	
	public void updatePenShow(boolean isPenDown){
		System.out.println("PenDown:" +isPenDown);
		penDown = isPenDown;		
	}
	
	private void updateTurtleSize(double width, double height){
		turtleWidth = width;
		turtleHeight = height;
	}
	
}
