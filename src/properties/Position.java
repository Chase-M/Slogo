package properties;

import javafx.geometry.Point2D;


/**
 * Passive Data Object for Position
 * 
 * @author Chase Malik, Timesh Patel
 *
 */
public class Position {
    private Point2D myPoint;
    private double myAngle;

    public Position (double x, double y, double angle) {
        myPoint = new Point2D(x, y);
        myAngle = angle;
    }

    public double getAngle () {
        return myAngle;
    }

    public double getX () {
        return myPoint.getX();

    }

    public double getY () {
        return myPoint.getY();
    }

    public Point2D getPoint () {
        return myPoint;
    }
}
