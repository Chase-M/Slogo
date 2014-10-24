package properties;

import javafx.geometry.Point2D;

public class Position {
	private Point2D myPoint;
	private double myAngle;
	public Position(double x, double y, double angle){
		myPoint = new Point2D(x,y);
		myAngle = angle;
	}
	

	public double getAngle(){
		return myAngle;
	}
	 
	public double getX(){
	    return myPoint.getX();
	    
	}
	public double getY(){
	    return myPoint.getY();
	}


    public Point2D getPoint () {
        // TODO Auto-generated method stub
        return myPoint;
    }
}
