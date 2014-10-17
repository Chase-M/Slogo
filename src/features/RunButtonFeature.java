package features;

import java.util.List;

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
import javafx.scene.layout.Pane;

public class RunButtonFeature extends Button implements Feature{
	public RunButtonFeature(BottomPane bottomPane, LeftPane leftPane, RightPane rightPane, Parser parser, Turtle turtle){
	super("Run");
	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

		        // TODO move this + don't only have one turtle + it shouldn't even be here
				List<Node> list = parser.parse(bottomPane.myCommand.getText());
				for(Node n: list){
					System.out.println(n.evaluate(turtle));
				}
		        final Button button = new Button(bottomPane.myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	bottomPane.myCommand.setText(button.getText());
				    }	
				    });
		        rightPane.update(button);
		        leftPane.update(bottomPane.myCommand.getText());		        
		        bottomPane.myCommand.clear();
		    }
		});	   
	
	
	
	
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
