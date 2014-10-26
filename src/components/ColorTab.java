package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import components.InfoTab;

import mainApplication.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ColorTab extends InfoTab{
	Map<String, Double> myColors;
	public ColorTab(String s, Controller c) { //Maybe change this to not have controller, give to "Save button" instead
		super(s, c);		
		myColors = new HashMap<String, Double>();
		
	}
	@Override
	public void update(Object o){
		myColors = (Map<String,Double>) o;
		myTextPane.getChildren().clear();
	myTextIndex = 0;
	//if(!myColors.equals(null)){
	for(String s:myColors.keySet()){
		myTextPane.add(new Label(s), 0, myTextIndex);
		myTextPane.add(new Label(myColors.get(s).toString()), 1, myTextIndex);
		myTextIndex++;
	//}
	}


	}
}
