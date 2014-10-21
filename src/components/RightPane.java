package components;

import java.util.ArrayList;
import java.util.List;

import features.TextDisplayFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.misc.Queue;


public class RightPane extends TextDisplayFactory{
	
	/**
	 * Initializes the console text display that will display console history
	 */
	//private int myCommandIndex;
	public RightPane(){
		super();
	//	myCommandIndex = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
/*	public void update(Button b){
		
		super.myTextPane.add(b, 0, super.myTextIndex);
		super.myTextIndex++;
	}
*/
}
