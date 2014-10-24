package properties;

import actor.Pen;

public class PenProperties{
	private Pen myPen;
	public PenProperties(Pen pen){
		myPen = pen;
	}
	public boolean isDown(){
		return myPen.isDown;
	}
	public double size(){
		return myPen.size;
	}
	public int getColorIndex(){
		return myPen.colorIndex;
	}
}
