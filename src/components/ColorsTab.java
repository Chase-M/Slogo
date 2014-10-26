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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorsTab extends InfoTab{
	Map<Integer, Color> myColors;
	public ColorsTab(String s, Controller c) { //Maybe change this to not have controller, give to "Save button" instead
		super(s, c);		
		myColors = new HashMap<Integer, Color>();
		
	}
	@Override
	public void update(Object o){
		myColors = (Map<Integer,Color>) o;
		myTextPane.getChildren().clear();
	myTextIndex = 0;
	//if(!myColors.equals(null)){
	for(Integer i:myColors.keySet()){
		myTextPane.add(new Label(i.toString()), 0, myTextIndex);
		myTextPane.add(new Rectangle(25, 25, myColors.get(i)), 1, myTextIndex);
		myTextIndex++;
	//}
	}


	}
}
