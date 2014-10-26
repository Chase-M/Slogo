package components;

import java.util.HashMap;
import java.util.Map;

import features.DisplayTurtle;
import mainApplication.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TurtlesTab extends InfoTab{
	private Map<Integer, DisplayTurtle> turtMap;
	public TurtlesTab(String s, Controller c) {
		super(s, c);
		turtMap = new HashMap<Integer, DisplayTurtle>();
	}
	@Override
	public void update(Object o){
		turtMap = (Map<Integer,DisplayTurtle>) o;
		myTextPane.getChildren().clear();
		myTextIndex = 0;
	/*	for(Integer i:turtMap.keySet()){
			System.out.println(i);
		DisplayTurtle turt = turtMap.get(i);
		myTextPane.add(new Label(i.toString()), 0, myTextIndex);
		myTextPane.add(new Label(Double.valueOf(turt.turtleX).toString()), 1, myTextIndex);
		myTextPane.add(new Label(turt.turtleY.toString), 1, myTextIndex+1);
		myTextPane.add(new Label(turt.), 1, myTextIndex+2);
		myTextIndex+=3;
	}
	*/
		for(Integer i:turtMap.keySet()){
			DisplayTurtle turt = turtMap.get(i);
			myTextPane.add(new Label(i.toString()), 0, myTextIndex);
			myTextPane.add(new Label(Double.valueOf(Math.round(turt.turtleX)).toString()), 1, myTextIndex);
			myTextPane.add(new Label(Double.valueOf(Math.round(turt.turtleY)).toString()), 1, myTextIndex+1);
			myTextPane.add(new Label(Double.valueOf(Math.toDegrees(turt.turtleAngle)).toString()), 1, myTextIndex+2);
			//myTextPane.add(new Label(i.toString()), 0, myTextIndex);
			//myTextPane.add(turtMap.get(i), 1, myTextIndex);
			myTextIndex+=3;
		
		}


	}
}
