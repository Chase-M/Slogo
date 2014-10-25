package properties;

import actor.Pen;

public class PenProperties{
	private Pen myPen;
	public PenProperties(Pen pen){
		myPen = pen;
	}
	public boolean isDown(){
		return myPen.isDown();
	}
	public double size(){
		return myPen.getSize();
	}
	public int getColorIndex(){
		return myPen.getColorIndex();
	}
	public int getID(){
		return myPen.getID();
	}
	
}
