

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
import components.InfoTab;
import components.LeftPane;
import components.PaneFactory;
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
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GUI extends Pane implements Observer{


	/**
	 * Activates the necessary components for GUI
	 */

	//private RightPane myRightPane;
	//private LeftPane myLeftPane;
	private Turtle myTurtle;
	private CenterPane myCenterPane;
	private Parser myParser;
	private BottomPane myBottomPane;
	private TopPane myTopPane;

	private InfoPane myLeftPane;
	private InfoPane myRightPane;


	private Controller myController;
	
	public static List<DisplayTurtle> myObjects;
	
	

	public GUI(Controller controller){
		myController = controller;

	}


	 void initiate(){

		myParser = new Parser();
		loadPanes();
		myController.createWorkspace(this);
		updatePanes();

	}


	private void loadPanes(){
		BorderPane pane = new BorderPane();
	//	myRightPane = new RightPane();		
		//myLeftPane = new LeftPane();
		//myLeftPane = new InfoPane(myController, "VariableTab", "HistoryTab");
		PaneFactory paneFac = new PaneFactory();
		myLeftPane = paneFac.makePane(myController, "LeftPane");
		myRightPane = paneFac.makePane(myController, "RightPane");
		//InfoPane2 rightPane = new InfoPane2("Colors", "Images");
		myTopPane = new TopPane();
		myBottomPane = new BottomPane();
		myCenterPane = new CenterPane();
		ScrollPane myScroller = new ScrollPane();
		myScroller.setMaxHeight(500);
		myScroller.setMaxWidth(600);
		//myScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		myScroller.setContent(myCenterPane);
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
		//Button newTurtle = (Button) features.myFeatureMap.get("NEWTURTLE");
		Button open = (Button) features.myFeatureMap.get("OPEN");
		Button save = (Button) features.myFeatureMap.get("SAVE");
		Button grid = (Button) features.myFeatureMap.get("GRID");
		Slider penSlider = (Slider) features.myFeatureMap.get("PENSLIDER");
		ComboBox penType = (ComboBox) features.myFeatureMap.get("PENTYPE");

		//String[] stringFeatures = new String[]{"OPEN", "SAVE", "GRID", "COLORPICK"};
		//for(String s: stringFeatures){
		//	myTopPane.addItems(features.myFeatureMap.get(s));
		//}
		myTopPane.addItems(open, save, grid, CP);
		myBottomPane.updateButton(run);

		//myBottomPane.getChildren().add(penSlider);
		myTopPane.mySettingsBar.addSlider(penSlider);
		myTopPane.mySettingsBar.addComboBox(penType);
		//myBottomPane.getChildren().add(newTurtle);

		pane.setBottom(myBottomPane);
		pane.setCenter(myScroller);	
		pane.setTop(myTopPane);	
		

		this.getChildren().add(pane);
		
		
	}
	private void updatePanes(){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		 paramMap.put("class components.HistoryTab", new Button("fd 50"));
        paramMap.put("class components.VarsTab", myController.getVariables());
        paramMap.put("class components.TurtlesTab", myController.getVariables());
        paramMap.put("class components.ColorsTab", myController.getColors());        
        paramMap.put("class components.SavedTab", new Button("here"));
        List<InfoTab> list = myLeftPane.myTabs;
		for(InfoTab t:list){
			//t.clear();
			//System.out.println(paramMap.get(t.getClass().toString()));
			t.update(paramMap.get(t.getClass().toString()));
			
		}
		List<InfoTab> list2 = myRightPane.myTabs;
		for(InfoTab t:list2){
			//t.clear();
			//System.out.println(paramMap.get(t.getClass().toString()));
			t.update(paramMap.get(t.getClass().toString()));
			
		}
		
	}
	
	
	public void initiateKeyPress(Scene s) {
		s.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case W: 
					System.out.println("up");
					try {
						myController.parseAndEvaluate("setheading 90 fd 25");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}break;					
				case S:
					System.out.println("down");
					try {
						myController.parseAndEvaluate("setheading 270 fd 25");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}break;					
				case D:
					System.out.println("right");
					try {
						myController.parseAndEvaluate("setheading 0 fd 25");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}break;					
				case A:
					System.out.println("left");
					try {
						myController.parseAndEvaluate("setheading 180 fd 25");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} break;
				}

			}	
		});
	}

	
	
	
	@Override
	public void update(Observable obs, Object props) {
		if(props instanceof TurtleProperties){
			myCenterPane.updateTurtlePosition((TurtleProperties) props);
		}
		if(props instanceof PenProperties){			
			//TODO Implement this based on pen given back
			System.out.println("Pen Prop runs");
			
			myCenterPane.updatePenProperties((PenProperties) props);
			System.out.println("pen prop size: "+ ((PenProperties) props).size());
			
			//myCenterPane.updateTurtlePosition((Position)props);
		}
		if(props instanceof StageProperties){
			System.out.println("Stage Prop runs");
			myCenterPane.clearScreen(((StageProperties) props).isClear);
			boolean b = ((StageProperties) props).isClear;
		}
		
		
	}
}
