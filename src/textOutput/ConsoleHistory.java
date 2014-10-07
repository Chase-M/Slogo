package textOutput;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.misc.Queue;


public class ConsoleHistory extends TextDisplayFactory{
	
	/**
	 * Initializes the console text display that will display console history
	 */
	private int myCounter;
	public ConsoleHistory(){
		super();
		myCounter = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void update(String s){
		myTextPane.add(new Button(s), 0, myCounter);
		myCounter++;
	}

}
