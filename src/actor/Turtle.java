package actor;

import java.util.Observable;

import javafx.geometry.Point2D;


public class Turtle extends Observable {
	private double myX;
	private double myY;
	private double myAngle;
	//private Pen myPen;
	
	public Turtle(double x, double y, double angle){
		myX = x;
		myY = y;
		myAngle = angle;
	}
	
	public double getX(){
		return myX;
	}
	
	public double getY(){
		return myY;
	}
	
	public double getAngle(){
		return myAngle;
	}
	
	public void updatePosition(double forward, double changeAngle){
		double newX = myX + Math.cos(myAngle)*forward;
		double newY = myY + Math.sin(myAngle)*forward;
		double newAngle = myAngle + changeAngle; // Not sure
		Point2D point = new Point2D(newX,newY);
		setChanged();
		notifyObservers(point);
	}
}