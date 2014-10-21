

package mainApplication;

import actor.Turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import components.BottomPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import components.CenterPane;
import features.FeatureSetUp;
import parser.Parser;
import properties.Position;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GUI extends Pane implements Observer{


	/**
	 * Activates the necessary components for GUI
	 */

	private RightPane myRightPane;
	private LeftPane myLeftPane;
	private Turtle myTurtle;
	private CenterPane myCenterPane;
	private Parser myParser;
	private BottomPane myBottomPane;
	private TopPane myTopPane;

	private Controller myController;

	public GUI(Controller controller){
		myController = controller;
		
	}

	 void initiate(){
		myParser = new Parser();
		loadPanes();
	}

	private void loadPanes(){
		BorderPane pane = new BorderPane();
		myRightPane = new RightPane();		
		myLeftPane = new LeftPane();
		myTopPane = new TopPane();
		myBottomPane = new BottomPane();
		myCenterPane = new CenterPane();
		pane.setLeft(myLeftPane);
		pane.setRight(myRightPane);
		List<Pane> components = new ArrayList<Pane>();
		components.add(myRightPane);
		components.add(myLeftPane);
		components.add(myTopPane);
		components.add(myBottomPane);
		components.add(myCenterPane);		
		
		FeatureSetUp features = new FeatureSetUp(components, myController);
		Button run = (Button) features.myFeatureMap.get("RUN");
		ColorPicker CP = (ColorPicker) features.myFeatureMap.get("COLORPICK");
		myBottomPane.getChildren().add(CP);
		myBottomPane.updateButton(run);
		pane.setBottom(myBottomPane);
		pane.setCenter(myCenterPane);	
		pane.setTop(myTopPane);
		this.getChildren().add(pane);
	}
	@Override
	public void update(Observable obs, Object props) {
		// TODO change this
		if(props instanceof Position){
			myCenterPane.updateTurtlePosition((Position)props);
		}
	}
}
