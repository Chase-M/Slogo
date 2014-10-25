package actor;

public class Pen {
	
	private static final double DEFAULT_SIZE  = 1;
	private static final int DEFAULT_COLOR_INDEX  = 1;
	private boolean isDown;
	private double mySize;
	private int myColorIndex;
	private int myID;
	
	public Pen(int id){
		isDown = true;
		mySize = DEFAULT_SIZE;
		myColorIndex = DEFAULT_COLOR_INDEX;
		myID = id;
	}
	public int getID(){
		return myID;
	}
	public double getSize(){
		return mySize;
	}
	public void setSize(double size){
		mySize = size;
	}
	public boolean isDown(){
		return isDown;
	}
	
	public void setDown(boolean b){
		isDown = b;
	}
	public int getColorIndex(){
		return myColorIndex;
	}
	public void setColorIndex(int i){
		myColorIndex = i;
	}
}
