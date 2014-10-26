package properties;

public class StageProperties {

    private boolean myClear;
    private int myIndex;

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
