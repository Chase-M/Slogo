package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import parser.Parser;
import actor.Turtle;
import javafx.scene.layout.Pane;
import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;


public class FeatureSetUp{
	public Map<String, Feature> myFeatureMap;
	public Map<String, Pane> myComponentMap;

	public FeatureSetUp(List<Pane> myComponents, Controller myController){
		myComponentMap = createComponentMap(myComponents);
		myFeatureMap = new HashMap<String, Feature>();
		RunButtonFeature run = new RunButtonFeature(myComponentMap, 
													myController);
		myFeatureMap.put("RUN", run);
		ColorPickerFeature colorPick = new ColorPickerFeature(myComponentMap);
		myFeatureMap.put("COLORPICK", colorPick);
		
		newTurtleButtonFeature newTurtle = new newTurtleButtonFeature(myComponentMap);
		myFeatureMap.put("NEWTURTLE", newTurtle);
		
	}
	
	public Map<String,Pane> createComponentMap(List<Pane> myComponents){
		Map<String, Pane> componentMap = new HashMap<String, Pane>();
		  for(Pane p: myComponents){
			   if(p instanceof BottomPane){
				   componentMap.put("BOTTOM", p);
			   }
			   else if(p instanceof CenterPane){
				   componentMap.put("CENTER", p);	
				   }
			   else if(p instanceof LeftPane){
				   componentMap.put("LEFT", p);
				   }
			   else if(p instanceof RightPane){
				   componentMap.put("RIGHT", p);
				   }
			   else if(p instanceof TopPane){
				   componentMap.put("TOP", p);
				   }
		   }
		return componentMap;
	}
}
