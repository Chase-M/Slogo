package actor;

import java.util.Observable;


public class Turtle extends Observable {
	private double myX;
	private double myY;
	private double myAngle;
	//private Pen myPen;
	
	public void updatePosition(double newX, double newY, double newAngle){
		notifyObservers();
		addObserver(null);
	}
}
