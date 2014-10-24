package properties;

import javafx.geometry.Point2D;

public class Position {
	private Point2D myPoint;
	private double myAngle;
	public Position(double x, double y, double angle){
		myPoint = new Point2D(x,y);
		myAngle = angle;
	}
	
	public Point2D getPoint(){
		return myPoint;
	}
	public double getAngle(){
		return myAngle;
	}
	public void setAngle(int angle){
	        myAngle=angle;
	}
}
