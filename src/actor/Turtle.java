package actor;

import java.util.Observable;

import properties.Position;
import javafx.geometry.Point2D;


public class Turtle extends Observable {
	private Position myPosition;
	private int myID;
	private Pen myPen;
	private boolean isActive;
	
	public Turtle(Position pos, Pen pen, int id){
		myPosition = pos;
		myPen = pen;
		myID = id;
		isActive = true;
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
	
	public int getID(){
		return myID;
	}
	
	public Position getPosition(){
		return myPosition;
	}
	
	public Pen getPen(){
		return myPen;
	}
	
	public void updatePosition(double newX, double newY, double newAngle){
		myPosition = new Position(newX,newY,newAngle);
		setChanged();
		notifyObservers(myPosition);
	}

	public boolean isActive() {
		return true;
	}
}