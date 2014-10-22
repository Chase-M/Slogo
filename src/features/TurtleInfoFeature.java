package features;

import java.util.Map;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import parser.Parser;
import actor.Turtle;

public class TurtleInfoFeature extends Label implements Feature{

	public TurtleInfoFeature(Map<String, Pane> componentMap, Parser parser, Turtle turtle){
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

//graphic turtle object with x y position. this will be updated by turtles in teh backened. implement observer. observe all teh shti int he back end. udpated accordingly.

//turtle and pens is all through observing. how does one add observers

//how to add observer?

//