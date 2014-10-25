

package mainApplication;

import actor.Turtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import components.BottomPane;
import components.InfoPane;
import components.InfoPane2;
import components.InfoTab;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import components.CenterPane;
import features.DisplayTurtle;
import features.FeatureSetUp;
import parser.Parser;
import properties.PenProperties;
import properties.Position;
import properties.StageProperties;
import properties.TurtleProperties;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GUI extends Pane implements Observer{


	/**
	 * Activates the necessary components for GUI
	 */

	//private RightPane myRightPane;
	private LeftPane myLeftPane;
	private Turtle myTurtle;
	private CenterPane myCenterPane;
	private Parser myParser;
	private BottomPane myBottomPane;
	private TopPane myTopPane;
	private InfoPane myInfoPane;


	private Controller myController;
	
	public static List<DisplayTurtle> myObjects;
	
	

	public GUI(Controller controller){
		myController = controller;

	}


	 void initiate(){

		myParser = new Parser();
		loadPanes();
		myController.createWorkspace(this);

	}


	private void loadPanes(){
		BorderPane pane = new BorderPane();
	//	myRightPane = new RightPane();		
		//myLeftPane = new LeftPane();
		myInfoPane = new InfoPane(myController, "VariableTab", "HistoryTab");
		InfoPane2 rightPane = new InfoPane2("Colors", "Images");
		myTopPane = new TopPane();
		myBottomPane = new BottomPane();
		myCenterPane = new CenterPane();
		pane.setLeft(myInfoPane);
		pane.setRight(rightPane);

		List<Pane> components = new ArrayList<Pane>();
		components.add(rightPane);
		components.add(myInfoPane);
		components.add(myTopPane);
		components.add(myBottomPane);
		components.add(myCenterPane);	
		
		FeatureSetUp features = new FeatureSetUp(components, myController);
		Button run = (Button) features.myFeatureMap.get("RUN");
		ColorPicker CP = (ColorPicker) features.myFeatureMap.get("COLORPICK");
		//Button newTurtle = (Button) features.myFeatureMap.get("NEWTURTLE");
		Button open = (Button) features.myFeatureMap.get("OPEN");
		Button save = (Button) features.myFeatureMap.get("SAVE");
		Button grid = (Button) features.myFeatureMap.get("GRID");
		//String[] stringFeatures = new String[]{"OPEN", "SAVE", "GRID", "COLORPICK"};
		//for(String s: stringFeatures){
		//	myTopPane.addItems(features.myFeatureMap.get(s));
		//}
		myTopPane.addItems(open, save, grid, CP);
		myBottomPane.updateButton(run);
		pane.setBottom(myBottomPane);
		pane.setCenter(myCenterPane);	
		pane.setTop(myTopPane);	
		

		this.getChildren().add(pane);
	}
	@Override
	public void update(Observable obs, Object props) {
		if(props instanceof TurtleProperties){
			myCenterPane.updateTurtlePosition((TurtleProperties) props);
		}
		if(props instanceof PenProperties){			
			//TODO Implement this based on pen given back
			
			myCenterPane.updatePenProperties((PenProperties) props);
			
			//myCenterPane.updateTurtlePosition((Position)props);
		}
		if(props instanceof StageProperties){
			System.out.println("Stage Prop runs");
			boolean b = ((StageProperties) props).isClear;
		}
		
		
	}
}
