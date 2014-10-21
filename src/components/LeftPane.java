package components;

import java.util.ArrayList;
import java.util.List;

import features.TextDisplayFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.misc.Queue;


public class LeftPane extends TextDisplayFactory{
	
	/**
	 * Initializes the console text display that will display console history
	 */
	//private int myCounter;
	public LeftPane(){
		super();
	//	myCounter = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
/*
	public void update(String s){
		super.myTextPane.add(new Label(s), 0, super.myTextIndex);
		super.myTextIndex++;
	}
*/
}
