package components;

import java.util.HashMap;
import java.util.Map;

import parser.CommandObject;
import mainApplication.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SavedTab extends InfoTab{
	Map<String, CommandObject> myCommandMap;
	public SavedTab(String s, Controller c) {
		super(s, c);
		myCommandMap = new HashMap<String, CommandObject>();
	}
	
	@Override
	public void update(Object o){
		myCommandMap = (Map<String, CommandObject>) o;
		myTextPane.getChildren().clear();
		myTextIndex = 0;
		for(String s:myCommandMap.keySet()){
			myTextPane.add(new Label(s), 0, myTextIndex);
			myTextIndex++;
		}
	}
}
