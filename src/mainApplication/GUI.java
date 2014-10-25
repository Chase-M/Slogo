

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
		InfoPane infoPane = new InfoPane("Variables", "History");
		InfoPane2 rightPane = new InfoPane2("Colors", "Images");
		myTopPane = new TopPane();
		myBottomPane = new BottomPane();
		myCenterPane = new CenterPane();
		pane.setLeft(infoPane);
		pane.setRight(rightPane);

		List<Pane> components = new ArrayList<Pane>();
		components.add(rightPane);
		components.add(infoPane);
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

		myTopPane.addButton(open);
		myTopPane.addButton(save);
		myTopPane.addButton(grid);
		myBottomPane.getChildren().add(CP);
		myBottomPane.updateButton(run);
		//myBottomPane.getChildren().add(newTurtle);
		pane.setBottom(myBottomPane);
		pane.setCenter(myCenterPane);	
		pane.setTop(myTopPane);	
		

		this.getChildren().add(pane);
		/**
		 * Don't delete this stuff
		 */
/*		Map<String, Double> myMap = new HashMap<String, Double>();
		myMap.put("this", 5.);
		myMap.put("that", 6.);
		myMap.put("the other", 6.7);
		myLeftPane.updateVars(myMap);
		*/
	}
	@Override
	public void update(Observable obs, Object props) {
		// TODO change this
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
