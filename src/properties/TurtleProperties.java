package properties;

import actor.Pen;
import actor.Turtle;

public class TurtleProperties {
    public int myId;
    public Pen myPen;
    public Position myPosition;
    
    public TurtleProperties(Turtle turtle){
        myId=turtle.getID();
        myPen=turtle.getPen();
        myPosition=turtle.getPosition();
    }
    
    
    
}
