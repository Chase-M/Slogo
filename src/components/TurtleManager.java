package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import properties.TurtleProperties;
import features.DisplayTurtle;

public class TurtleManager {
	Map<Integer, DisplayTurtle> myTurtleMap;
	public TurtleManager(){
		myTurtleMap = new HashMap<Integer, DisplayTurtle>();
	}
	public void update(TurtleProperties props){
		int ID = props.myId;
		DisplayTurtle turt = (myTurtleMap.containsKey(ID)) ? myTurtleMap.get(ID) : new DisplayTurtle();
		turt.updatePosition(props.myPosition);
		//turt.updateHeading(p);
		//turt.update();
		
	}

}
