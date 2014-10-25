package properties;

import actor.Pen;
import actor.Turtle;

public class TurtleProperties {
    public int myId;
    public Pen myPen;
    public Position myPosition;
    public boolean isShowing;
    
    public TurtleProperties(Turtle turtle){
        myId=turtle.getID();
        myPen=turtle.getPen();
        myPosition=turtle.getPosition();
        isShowing = turtle.isShowing();
        
    }
    
    
    
}
