package features;


import java.util.ArrayList;
import java.util.List;

import components.CenterPane;
import properties.Position;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

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
	private double currentX;
	private double currentY;
	private double theta;
	
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
	
	
//	public void updatePosition(Position pos){
//		turtleX = pos.getX();
//		turtleY = pos.getY();
//		turtleAngle = pos.getAngle();
//		
//		double xDiff = (pos.getX()+middleX)-currentX;
//		double yDiff = currentY-(middleY-pos.getY());
//		
//		if(xDiff == 0){
//			theta = 90;
//		} else {
//			theta = Math.atan(yDiff/xDiff);
//		}
//		
//		double totaldistance = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
//		
//		Timeline tl = new Timeline();
//		tl.setCycleCount(totaldistance/10);
//		KeyFrame update = new KeyFrame(Duration.seconds(0.05), 
//				new EventHandler<ActionEvent>(){			
//			public void handle(ActionEvent event){
//				
//				updateImage(turtleX, turtleY, turtleAngle);
//				
//				
//			}
//		
//		});
//		
//		tl.getKeyFrames().add(update);
//		tl.play();	
//	}
//	
	public void updateTurtleShow(boolean show){	
		System.out.println("show:" +show);		
		isTurtleShowing = show;		
		if(show == false){
			myCenterPane.getChildren().remove(myImage);
			System.out.println("removed");
		}
		
	}
	
	public void updateImage(double moveX, double moveY, double turtleAngle2){
		myImage.setLayoutX(middleX+moveX);
		myImage.setLayoutY(middleY-moveY);
		myImage.setRotate(90-Math.toDegrees(turtleAngle2));
		currentX = middleX+moveX;
		currentY = middleY+moveY;
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
