package graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Turtle extends GraphicObject{
	public ImageView turtleView;

	@Override
	public void update() {		
	}
	
	
	public void addTurtleImage(){

		Image image = new Image("graphics/turtle.png");		
		turtleView = new ImageView (image);
		turtleView.setFitWidth(50);		
		turtleView.setFitHeight(80);
		turtleView.setLayoutX(275);
		turtleView.setLayoutY(200);
	}


}
