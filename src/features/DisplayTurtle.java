package features;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayTurtle {
	
	//private ImageView turtleGraphic;
	private double turtleX;
	private double turtleY;
	private static int turtleWidth;
	private static int turtleHeight;
	
	private int turtleID;
	

	public DisplayTurtle(){
		turtleWidth = 26;
		turtleHeight = 50;
	}
	
	public static ImageView makeNewTurtle(){
		Image image = new Image("features/turtle.png");	
		
		ImageView turtleGraphic = new ImageView (image);
		turtleGraphic.setFitWidth(26);		
		turtleGraphic.setFitHeight(50);
		turtleGraphic.setLayoutX(275);
		turtleGraphic.setLayoutY(200);
		
		return turtleGraphic;
		
	}
	
	public void setTurtleID(int ID){
		turtleID = ID;	
	}
	
	
	
	
}
