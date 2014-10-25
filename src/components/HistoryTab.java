package components;

import javafx.scene.control.Button;

public class HistoryTab extends InfoTab{

	public HistoryTab(String s) {
		super(s);
	}
	
	@Override
	public void update(Object o){
		Button b = (Button) o;
		myTextPane.add(b, 0, myTextIndex);	
		myTextIndex++;
	}
}
