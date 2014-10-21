package features;

import java.util.List;
import java.util.Map;

import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import actor.Turtle;
import parser.Node;
import parser.Parser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class RunButtonFeature extends Button implements Feature{
	public RunButtonFeature(Map<String, Pane> componentMap, Parser parser, Turtle turtle){
	super("Run");
	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	BottomPane bottomPane = (BottomPane)componentMap.get("BOTTOM");
		    	RightPane rightPane = (RightPane)componentMap.get("RIGHT");
		    	LeftPane leftPane = (LeftPane)componentMap.get("LEFT");

		        // TODO move this + don't only have one turtle + it shouldn't even be here
				List<Node> list = parser.parse(bottomPane.myCommand.getText());
				for(Node n: list){
					System.out.println(n.evaluate(turtle));
				}
		        final Button button = new Button(bottomPane.myCommand.getText());
		        final Label label = new Label(bottomPane.myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	bottomPane.myCommand.setText(button.getText());
				    }	
				    });
		        rightPane.update(button);
		        leftPane.update(label);		        
		        bottomPane.myCommand.clear();
		        //bottomPane.update();
		    }
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
