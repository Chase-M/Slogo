package textOutput;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import sun.misc.Queue;


public class ConsoleHistory extends TextDisplayFactory{
	
	/**
	 * Initializes the console text display that will display console history
	 */
	List<String> myCommands;
	List<Label> myLabels;
	public ConsoleHistory(){
		myCommands = new ArrayList<String>();
		myLabels = new ArrayList<Label>();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void update(String s){
		myCommands.add(s);
	}
	public List<Label> giveLabels(){
		//myLabels = new ArrayList<Label>();
		for(String s:myCommands){
			myLabels.add(new Label(s));
		}
		return myLabels;
	}

}
