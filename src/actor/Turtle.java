package actor;

import java.util.Observable;
import properties.PenProperties;
import properties.Position;
import properties.TurtleProperties;
import javafx.geometry.Point2D;


public class Turtle extends Observable {
    private static final Position DEFAULT_POSITION = new Position(0, 0, Math.PI / 2);
    private static final int DEFAULT_SHAPE = 0;
    private Position myPosition;
    private int myID;
    private Pen myPen;
    private boolean myActive;
    private boolean myShowing;
    private int myShape;

    public Turtle (Position pos, int id) {
        myPosition = pos;
        myID = id;
        myPen = new Pen(myID);
        myActive = true;
        myShowing = true;
        myShape = DEFAULT_SHAPE;
    }

    public Turtle (int id) {
        this(DEFAULT_POSITION, id);
    }

    public double getX () {
        return myPosition.getX();
    }

    public double getY () {
        return myPosition.getY();
    }

    public Point2D getPoint () {
        return myPosition.getPoint();
    }

    public double getAngle () {
        return myPosition.getAngle();
    }

    public int getID () {
        return myID;
    }

    public Position getPosition () {
        return myPosition;
    }

    public Pen getPen () {
        return myPen;
    }

    public void updatePosition (double newX, double newY, double newAngle) {
        myPosition = new Position(newX, newY, newAngle);
        setChangedandNotify(new TurtleProperties(this));
    }

    public void setShowing (boolean showing) {
        myShowing = showing;
        setChangedandNotify(new TurtleProperties(this));
    }

    public void setChangedandNotify (Object obj) {
        setChanged();
        notifyObservers(obj);
    }

    public boolean isActive () {
        return myActive;
    }

    public void setActive (boolean active) {
        myActive = active;
    }

    public boolean isShowing () {
        return myShowing;
    }

    public void changedPen () {
        setChangedandNotify(new PenProperties(myPen));
    }

    public void changeShape (int index) {
        myShape = index;
        setChangedandNotify(new TurtleProperties(this));
    }

    public int getShape () {
        return myShape;
    }
}
