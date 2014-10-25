package components;

import mainApplication.GUI;
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

	private ImageView turtleGraphic;
	private double turtleX;
	private double turtleY;
	private int turtleWidth = 26;
	private int turtleHeight = 50;
	private Label myLabel;
	private TurtleManager myTurtleManager = new TurtleManager(this);
	public GridPane referenceGrid;

	public CenterPane(){
		super();
		this.setStyle("-fx-background-color: white");	
		//		Image image = new Image("mainApplication/turtle.png");		
		//		turtleView = new ImageView (image);
		//		turtleView.setFitWidth(26);		
		//		turtleView.setFitHeight(50);
		//		turtleView.setLayoutX(275);
		//		turtleView.setLayoutY(200);		
		//		turtleX = 275;
		//		turtleY = 200;


		//turtleGraphic = firstTurtle.makeNewTurtle();
		//GUI.myObjects.add(firstTurtle);
		
		referenceGrid = createReferenceGrid();
		myLabel = new Label("Turtle X: "+(275-turtleX)+"\nTurtle Y: "+(200-turtleY));
		this.getChildren().add(myLabel);
		this.getChildren().add(referenceGrid);
		//this.getChildren().add(turtleGraphic);
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
				this.getChildren().add(t.myImage);
				//this.getChildren().add(t.myLine);			
		}

	}
	@Override
	public void update() {

	}

	public void updateTurtlePosition(TurtleProperties pos){
		myTurtleManager.update(pos);
		for(DisplayTurtle t:myTurtleManager.myTurtleMap.values()){
			if(!this.getChildren().contains(t.myImage)){
			this.getChildren().add(t.myImage);

			}
		}
		//	int ID = pos.myId;
		//	double tempX = 275+pos.getPoint().getX();
		//	double tempY = 200-pos.getPoint().getY();
		//	drawLine(tempX, tempY);
		//		turtleView.setLayoutX(turtleX);
		//		turtleView.setLayoutY(turtleY);
		myLabel.setText("Turtle X: "+(275-turtleX)+"\nTurtle Y: "+(200-turtleY));
	}


	private GridPane createReferenceGrid(){
		
		GridPane refGrid = new GridPane();
		refGrid.setPrefSize(600,500);
		for(int i = 0; i < 12; i++){
		refGrid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		for(int i = 0; i<10; i++){
		refGrid.getRowConstraints().add(new RowConstraints(50));
		}
		
		return refGrid;
		
	}
	


}
