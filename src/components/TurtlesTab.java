package components;

import mainApplication.Controller;
import javafx.scene.control.Button;

public class TurtlesTab extends InfoTab{

	public TurtlesTab(String s, Controller c) {
		super(s, c);
	}
	
	@Override
	public void update(Object o){
		Button b = (Button) o;
		myTextPane.add(b, 0, myTextIndex);	
		myTextIndex++;
	}
}
