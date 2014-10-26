package features;


import java.util.ArrayList;
import java.util.List;

import components.CenterPane;
import properties.Position;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class DisplayTurtle {

	//private ImageView turtleGraphic;
	public double turtleX;
	public double turtleY;
	public double turtleAngle;
	private double turtleWidth;
	private double turtleHeight;
	private ImageView turtleGraphic;
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
	private int penType;
	private Timeline tl;
	private boolean animate;
	private double currentAngle;
	private Path myPath;
	public double animationSpeed;
	private double time;

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
		currentX = 0;
		currentY = 0;
		penDown =true;
		Image image = new Image("features/turtle.png");		
		myImage = new ImageView (image);
		myImage.setFitWidth(turtleWidth);		
		myImage.setFitHeight(turtleHeight);	
		updateImage(turtleX, turtleY, turtleAngle);
		System.out.println("getXY: "+myImage.getX()+ "  "+myImage.getY());
		myPen = new Pen();
		myCenterPane = pane;
		linesDrawn = new ArrayList<Line>();
		penType = 1;
		animate = false;
		currentAngle = 0;
		animationSpeed = 50;
		time = 1;
	}

	public void setTurtleID(int ID){
		turtleID = ID;	
	}
	public void updatePosition(Position pos){
		turtleX = pos.getX();
		turtleY = pos.getY();
		turtleAngle = pos.getAngle();
		double xDiff = turtleX-currentX;
		double yDiff = turtleY-currentY;
		double distance = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
		
		time = distance/animationSpeed;
		System.out.println("time is now:" +time);
		
		if(animate == false){
			myImage.setTranslateX(0);
			myImage.setTranslateY(0);
		updateImage(pos.getX(), pos.getY(), turtleAngle);	
		
		updateLine(turtleX, turtleY);
		
		} else if(animate == true){	
			
			
			animateTurtlePosition();
			animateTurtleAngle(turtleAngle);			

			}
		
	}
	
	
		
	private void animateTurtlePosition(){
		System.out.println("tt time:" +time);

		TranslateTransition tt = new TranslateTransition(Duration.seconds(time), myImage);
		
		tt.setToX(myImage.getX()+turtleX);
		tt.setToY(myImage.getY()-turtleY);
		
		updateLine(turtleX, turtleY);
					
		tt.play();	
	}
	
	
	private void animateTurtleAngle(double angle){
		
		
		RotateTransition rt = new RotateTransition(Duration.millis(500), myImage);
		rt.setFromAngle(currentAngle);
		rt.setToAngle(90-Math.toDegrees(angle));
		currentAngle = (90-Math.toDegrees(angle));
		
		rt.play();
		
	}

	public void updatePenType(int type){
		penType = type;
	}



	public void updateImage(double moveToX, double moveToY, double turtleAngle2){
		myImage.setLayoutX(middleX+turtleX);
		myImage.setLayoutY(middleY-turtleY);
		myImage.setRotate(90-Math.toDegrees(turtleAngle2));
		
		currentX = turtleX;
		currentY = turtleY;
	}

	

	public void updateTurtleShow(boolean show){			
		isTurtleShowing = show;		
		if(show == false){
			myCenterPane.getChildren().remove(myImage);
			System.out.println("removed");
		}

	}


	private void updateLine(double x, double y){
		myLine = myPen.drawLine(turtleX, turtleY, turtleWidth, turtleHeight, penType);
		if(penDown == true){
			myCenterPane.getChildren().add(myLine);	
			linesDrawn.add(myLine);
		}
	}

	public void updatePenShow(boolean isPenDown){
		penDown = isPenDown;		
	}

	private void updateTurtleSize(double width, double height){
		turtleWidth = width;
		turtleHeight = height;
	}
	
	public void updateAnimate(boolean bool){
		System.out.println("updateAnimate in DT is called");
		animate = bool;
		System.out.println(animate);
	}
	
	public void updateSpeed(double speed){
		animationSpeed = speed;
		System.out.println("t.animationSpeed is now:  "+animationSpeed);
	}

}
