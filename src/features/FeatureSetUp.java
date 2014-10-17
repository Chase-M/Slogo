package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public FeatureSetUp(List<Pane> myComponents, Parser parser, Turtle turtle){
		
		Pane bottomPane = new BottomPane();
		Pane centerPane = new CenterPane();
		Pane topPane = new TopPane();
		Pane leftPane = new LeftPane();
		Pane rightPane = new RightPane();
		   for(Pane p: myComponents){
			   if(p instanceof BottomPane){
				   bottomPane = p;
			   }
			   if(p instanceof CenterPane){
				   centerPane = p;
			   }
			   if(p instanceof LeftPane){
				   leftPane = p;
			   }
			   if(p instanceof RightPane){
				   rightPane = p;
			   }
			   if(p instanceof TopPane){
				   topPane = p;
			   }
		   }
		
		
		
		myFeatureMap = new HashMap<String, Feature>();
		RunButtonFeature run = new RunButtonFeature((BottomPane)bottomPane, 
													(LeftPane)leftPane, 
													(RightPane)rightPane, 
													parser, turtle);
		myFeatureMap.put("RUN", run);
		
		ColorPickerFeature colorPick = new ColorPickerFeature((CenterPane) centerPane);
		myFeatureMap.put("COLORPICK", colorPick);
		
	}
}
