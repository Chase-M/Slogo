package actor;

/**
 * @author Timesh Patel, Chase Malik
 */
public class Pen {

    private static final double DEFAULT_SIZE = 1;
    private static final int DEFAULT_COLOR_INDEX = 1;
    private boolean myDown;
    private double mySize;
    private int myColorIndex;
    private int myID;

    /**
     * Pen class represents the pen of a turtle
     * has size, width, a color index, id of the turtle it belongs to
     * and whether its up or down
     * 
     * @param id
     */
    public Pen (int id) {
        myDown = true;
        mySize = DEFAULT_SIZE;
        myColorIndex = DEFAULT_COLOR_INDEX;
        myID = id;
    }

    public int getID () {
        return myID;
    }

    public double getSize () {
        return mySize;
    }

    public void setSize (double size) {
        mySize = size;
    }

    public boolean isDown () {
        return myDown;
    }

    public void setDown (boolean b) {
        myDown = b;
    }

    public int getColorIndex () {
        return myColorIndex;
    }

    public void setColorIndex (int i) {
        myColorIndex = i;
    }
}
