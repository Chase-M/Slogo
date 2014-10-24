package features;

import properties.Position;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayTurtle {
	
	//private ImageView turtleGraphic;
	private double turtleX;
	private double turtleY;
	private static int turtleWidth;
	private static int turtleHeight;
	
	private int turtleID;
	public ImageView myImage;
	

	public DisplayTurtle(){
		turtleWidth = 26;
		turtleHeight = 50;
		turtleX = 0;
		turtleY = 0;

		Image image = new Image("features/turtle.png");	
		
		myImage = new ImageView (image);
		myImage.setFitWidth(26);		
		myImage.setFitHeight(50);
		
		updateImage(turtleX, turtleY);
		//myImage.setLayoutX(275);
		//myImage.setLayoutY(200);
		
		//return turtleGraphic;
		
	}
	
	public void setTurtleID(int ID){
		turtleID = ID;	
	}
	public void updatePosition(Position pos){
		turtleX = pos.getX();
		turtleY = pos.getY();
		updateImage(turtleX, turtleY);
		
		
	}
	public void updateImage(double turtleX2, double turtleY2){
		myImage.setLayoutX(200-turtleX2);
		myImage.setLayoutY(275-turtleY2);
	}
	
	
	
	
}
