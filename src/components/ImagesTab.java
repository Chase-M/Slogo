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
import javafx.scene.image.ImageView;

public class ImagesTab extends InfoTab{
	Map<Integer, ImageView> myImages;
	public ImagesTab(String s, Controller c) {
		super(s, c);		
		myImages = new HashMap<Integer, ImageView>();
		
	}
	@Override
	public void update(Object o){
		myImages = (Map<Integer,ImageView>) o;
		myTextPane.getChildren().clear();
	myTextIndex = 0;
	for(Integer i:myImages.keySet()){
		myTextPane.add(new Label(i.toString()), 0, myTextIndex);
		myTextPane.add(myImages.get(i), 1, myTextIndex);
		myTextIndex++;
	
	}


	}
}
