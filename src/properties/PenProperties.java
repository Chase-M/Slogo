package properties;

import actor.Pen;


/**
 * Passive Data Object for Pen
 * 
 * @author Chase Malik, Timesh Patel
 *
 */
public class PenProperties {
    private Pen myPen;

    public PenProperties (Pen pen) {
        myPen = pen;
    }

    public boolean isDown () {
        return myPen.isDown();
    }

    public double size () {
        return myPen.getSize();
    }

    public Integer getColorIndex () {
        return myPen.getColorIndex();
    }

    public int getID () {
        return myPen.getID();
    }

}
