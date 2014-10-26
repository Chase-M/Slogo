package properties;

import actor.Pen;
import actor.Turtle;


public class TurtleProperties {
    private int myID;
    private Pen myPen;
    private Position myPosition;
    private boolean myShowing;
    private int myShape;

    public TurtleProperties (Turtle turtle) {
        myID = turtle.getID();
        myPen = turtle.getPen();
        myPosition = turtle.getPosition();
        myShowing = turtle.isShowing();
        myShape = turtle.getShape();
    }

    public int getID () {
        return myID;
    }

    public Pen getPen () {
        return myPen;
    }

    public Position getPosition () {
        return myPosition;
    }
    
    public boolean isShowing () {
        return myShowing;
    }
    
    public int getShape () {
        return myShape;
    }
}
