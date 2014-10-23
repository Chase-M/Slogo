package features;

import java.util.Map;

import mainApplication.GUI;
import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class newTurtleButtonFeature extends Button implements Feature {


	@Override
	public void update() {
		// TODO Auto-generated method stub

	}	

	public newTurtleButtonFeature(Map<String, Pane> componentMap){	
		super("New Turtle");
		BottomPane bottomPane = (BottomPane)componentMap.get("BOTTOM");
		RightPane rightPane = (RightPane)componentMap.get("RIGHT");
		LeftPane leftPane = (LeftPane)componentMap.get("LEFT");
		CenterPane centerPane = (CenterPane)componentMap.get("CENTER");

		this.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				System.out.println("new turtle added");
				
				DisplayTurtle newDisplayTurtle = new DisplayTurtle();
				newDisplayTurtle.setTurtleID(50); //keep a count of turtles somewhere?
				ImageView newTurtleGraphic = new ImageView();
				newTurtleGraphic = newDisplayTurtle.makeNewTurtle();
				GUI.myObjects.add(newDisplayTurtle);
			
				centerPane.getChildren().add(newTurtleGraphic);		
				
				System.out.println(GUI.myObjects.size());


			}
		});
	}





}
