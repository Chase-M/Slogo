package actor;

import java.util.Observable;

import properties.Position;
import javafx.geometry.Point2D;


public class Turtle extends Observable {
	private Position myPosition;
	private int myID;
	//private Pen myPen;
	
	public Turtle(double x, double y, double angle){
		myPosition = new Position(x,y,angle);
	}
	
	public double getX(){
		return myPosition.getPoint().getX();
	}
	
	public double getY(){
		return myPosition.getPoint().getY();
	}
	
	public double getAngle(){
		return myPosition.getAngle();
	}
	
	public Point2D getPoint(){
		return myPosition.getPoint();
	}
	
	public void updatePosition(double newX, double newY, double newAngle){
		myPosition = new Position(newX,newY,newAngle);
		setChanged();
		notifyObservers(myPosition);
	}
}