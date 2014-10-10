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
	
	
	public void updatePosition(double newX, double newY, double newAngle){
		Point2D point = new Point2D(newX,newY);
		setChanged();
		notifyObservers(point);
	}
}
