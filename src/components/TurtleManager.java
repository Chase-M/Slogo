package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import properties.TurtleProperties;
import features.DisplayTurtle;

public class TurtleManager {
	Map<Integer, DisplayTurtle> myTurtleMap;
	private CenterPane myCenterPane;
	
	public TurtleManager(CenterPane pane){
		myTurtleMap = new HashMap<Integer, DisplayTurtle>();
		myCenterPane = pane;
		
	}
	public void update(TurtleProperties props){
		int ID = props.myId;
		DisplayTurtle turt;
		if(myTurtleMap.containsKey(ID)){
			turt = myTurtleMap.get(ID);
		}
		else{
			turt = new DisplayTurtle(myCenterPane);
			myTurtleMap.put(ID, turt);
			//turt.updatePosition
		}
		
		turt.updatePosition(props.myPosition);

		//turt.updateHeading(p);
		//turt.update();
		
	}

}
