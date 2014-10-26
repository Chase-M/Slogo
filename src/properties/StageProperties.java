package properties;

public class StageProperties {

    private boolean myClear;
    private int myIndex;

    /**
     * Passive Data Object for the Stage
     * 
     * @author Chase Malik, Timesh Patel
     *
     */
    public StageProperties (boolean b, int index) {
        myClear = b;
        myIndex = index;
    }

    public int getIndex () {
        return myIndex;
    }

    public void setIndex (int index) {
        myIndex = index;
    }

    public boolean isClear () {
        return myClear;
    }

    public void setClear (boolean clear) {
        myClear = clear;
    }
}
