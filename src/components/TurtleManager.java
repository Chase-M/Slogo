package components;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import properties.PenProperties;
import properties.TurtleProperties;
import features.DisplayTurtle;
/**
 *  TurtleManager is a class that maintains a list of
 *  graphic turtles that are displayed to the user.
 *  It updates the pen and turtle positions.
 *
 */
public class TurtleManager {
	public Map<Integer, DisplayTurtle> myTurtleMap;
	private CenterPane myCenterPane;
	private BottomPane myBottomPane;
	private Color testC;
	private Map<Integer, ImageView> myImageMap;
	
	public TurtleManager(CenterPane pane){
		myTurtleMap = new HashMap<Integer, DisplayTurtle>();
		myCenterPane = pane;
		myImageMap = new HashMap<Integer, ImageView>();
		
	}
	public void updateImageMap(Map<Integer, ImageView> imageMap){
		myImageMap = imageMap;
	}
	public void update(TurtleProperties props) throws NullPointerException{
		int ID = props.getID();
		DisplayTurtle turt;
		if(myTurtleMap.containsKey(ID)){
			turt = myTurtleMap.get(ID);
		}
		else{
			turt = new DisplayTurtle(myCenterPane);
			myTurtleMap.put(ID, turt);
		}
		turt.updateImageView(myImageMap.get(Integer.valueOf(props.getShape())));
		turt.updatePosition(props.getPosition());
		turt.updateTurtleShow(props.isShowing());

	}

	
	public void updatePenProperties(PenProperties props){
		int ID = props.getID();
		DisplayTurtle turt;
			turt = myTurtleMap.get(ID);		
		turt.updatePenShow(props.isDown());
		turt.updatePenWidth(props.size());
		turt.updatePenColor((Color) myCenterPane.colorsMap.get(props.getColorIndex()));
	}
	

	
	public void clearScreen(boolean clear){
		if(clear == true){			
			myTurtleMap.clear();
			myCenterPane.getChildren().clear();	
			myCenterPane.getChildren().add(myCenterPane.referenceGrid);
		}
	}
	

}
