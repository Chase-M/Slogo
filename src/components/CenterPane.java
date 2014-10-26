package components;

import java.util.Map;

import mainApplication.GUI;
import properties.PenProperties;
import properties.Position;
import properties.TurtleProperties;
import features.DisplayTurtle;
import features.Feature;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CenterPane extends Pane implements Feature{
	
//	private VBox myDrawer;
//	private ScrollPane myScroller;
	private ImageView turtleGraphic;
	private double turtleX;
	private double turtleY;
	private int turtleWidth = 26;
	private int turtleHeight = 50;
	private Label myLabel;
	public TurtleManager myTurtleManager;
	public GridPane referenceGrid;
	public Map<Integer, Color> colorsMap;
	public boolean animate;

	public CenterPane(){
		super();
		myTurtleManager = new TurtleManager(this);
		this.setStyle("-fx-background-color: white");	
		referenceGrid = createReferenceGrid();
		animate = false;
		myLabel = new Label("Turtle X: "+(275-turtleX)+"\nTurtle Y: "+(200-turtleY));
		this.getChildren().add(myLabel);

		this.getChildren().add(referenceGrid);
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
				this.getChildren().add(t.myImage);		
		}
		
	}
	@Override
	public void update() {

	}

	public void updateTurtlePosition(TurtleProperties pos){
		myTurtleManager.update(pos);
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
			if(!this.getChildren().contains(t.myImage)){
				if(t.isTurtleShowing){
			this.getChildren().add(t.myImage);
				}
			}
			//myTurtlesTab.myPositionMap.put(t.myId, );
		}
		}
	
	public void updatePenProperties(PenProperties props){
		myTurtleManager.updatePenProperties(props);		
	}

	public void clearScreen(boolean clear){
		myTurtleManager.clearScreen(clear);
	}
	
	public void updatePenType(int type){
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
			t.updatePenType(type);
		}
	}
	
	public void updateAnimate(boolean bool){
		animate = bool;
		
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
			t.updateAnimate(bool);
		}
		
	}

	private GridPane createReferenceGrid(){
		
		GridPane refGrid = new GridPane();
		refGrid.setPrefSize(600,400);
		refGrid.getColumnConstraints().add(new ColumnConstraints(38));
		refGrid.getRowConstraints().add(new RowConstraints(25));
		for(int i = 0; i < 12; i++){
		refGrid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		for(int i = 0; i<10; i++){
		refGrid.getRowConstraints().add(new RowConstraints(50));
		}
		
		return refGrid;
		
	}
	
	public void initiateColorsMap(Map<Integer, Color> map ){	
		colorsMap = map;		
	}
	
	public void updateAnimationSpeed(double speed){
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
			t.updateSpeed(speed);
			
		}
	}


}
