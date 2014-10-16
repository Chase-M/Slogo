package frontEnd;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TurtleWindow extends Pane implements Feature{

	private ImageView turtleView;
	
	public TurtleWindow(){
		super();
		this.setStyle("-fx-background-color: white");	
		Image image = new Image("frontEnd/turtle.png");		
		turtleView = new ImageView (image);
		turtleView.setFitWidth(26);		
		turtleView.setFitHeight(50);
		turtleView.setLayoutX(275);
		turtleView.setLayoutY(200);	
		this.getChildren().add(turtleView);
	}
	@Override
	public void update() {
		
	}
	public void updateTurtlePosition(double newX, double newY){
		turtleView.setLayoutX(newX);
		turtleView.setLayoutY(newY);
	}

}
