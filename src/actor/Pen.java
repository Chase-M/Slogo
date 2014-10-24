package actor;

public class Pen {
	
	public static final double DEFAULT_SIZE  = 1;
	public static final int DEFAULT_COLOR_INDEX  = 0;
	public boolean isDown;
	public double size;
	public int colorIndex;
	
	public Pen(){
		isDown = true;
		size = DEFAULT_SIZE;
		colorIndex = DEFAULT_COLOR_INDEX;
	}
}
