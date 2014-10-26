package components;

import mainApplication.Controller;
import javafx.scene.control.Button;

public class HistoryTab extends InfoTab{

	public HistoryTab(String s, Controller c) {
		super(s, c);
	}
	
	@Override
	public void update(Object o){
		Button b = (Button) o;
		myTextPane.add(b, 0, myTextIndex);	
		myTextIndex++;
	}
}
