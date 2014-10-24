package actor;

import java.util.Observable;
import properties.Position;
import properties.TurtleProperties;
import javafx.geometry.Point2D;


public class Turtle extends Observable {
	private Position myPosition;
	private int myID;
	private Pen myPen;
	private boolean isActive;
	private boolean isShowing;
	
	public Turtle(Position pos, int id){
		myPosition = pos;
		myID = id;
		myPen = new Pen(myID);
		isActive = true;
	}
	
	public double getX(){
		return myPosition.getX();
	}
	
	public double getY(){
		return myPosition.getY();
	}
	public Point2D getPoint(){
	    return myPosition.getPoint();
	}
	public double getAngle(){
		return myPosition.getAngle();
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
		setChangedandNotify(new TurtleProperties(this));
	}
	
	public void setShowing(boolean showing){
		isShowing = showing;
		setChangedandNotify(new TurtleProperties(this));
	}

	public void setChangedandNotify(Object obj){
		setChanged();
		notifyObservers(obj);
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean active) {
		isActive = active;
	}

	public boolean isShowing() {
		return isShowing;
	}
}