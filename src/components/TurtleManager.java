package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import properties.PenProperties;
import properties.TurtleProperties;
import features.DisplayTurtle;

public class TurtleManager {
	public Map<Integer, DisplayTurtle> myTurtleMap;
	private CenterPane myCenterPane;
	private BottomPane myBottomPane;
	private Color testC;
	private Map<Integer, ImageView> myImageMap;
	
	public TurtleManager(CenterPane pane){
		myTurtleMap = new HashMap<Integer, DisplayTurtle>();
		myCenterPane = pane;
		//myBottomPane = bPane;
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
			turt = new DisplayTurtle(myCenterPane, myBottomPane);
			myTurtleMap.put(ID, turt);
			//turt.updatePosition
		}
	//	System.out.println(myImageMap.get(Integer.valueOf(props.getShape())).toString());
		//try{
		turt.updateImageView(myImageMap.get(Integer.valueOf(props.getShape())));
	//	}
	//	catch(NullPointerException e){
		//	myBottomPane.myErrors.setText("ERRORS:\nImage Index out of Palette Bounds");
		//}
		turt.updatePosition(props.getPosition());
		turt.updateTurtleShow(props.isShowing());
		//turt.updatePenShow(penProps.isDown());


	}

	
	public void updatePenProperties(PenProperties props){
		int ID = props.getID();
	//	System.out.println("updatePenProperties");
		DisplayTurtle turt;
			turt = myTurtleMap.get(ID);		
		turt.updatePenShow(props.isDown());
		turt.myPen.updatePenWidth(props.size());
		turt.myPen.updatePenColor((Color) myCenterPane.colorsMap.get(props.getColorIndex()));
	}
	

	
	public void clearScreen(boolean clear){
		if(clear == true){			
			myTurtleMap.clear();
			myCenterPane.getChildren().clear();			
		}
	}
	

}
