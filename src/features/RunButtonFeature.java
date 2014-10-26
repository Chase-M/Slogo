package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.InfoPane;
import components.InfoTab;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class RunButtonFeature extends Button implements Feature{
	public RunButtonFeature(Map<String, Pane> componentMap, Controller myController){
	super("Run");
	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	BottomPane bottomPane = (BottomPane)componentMap.get("class components.BottomPane");

		    	if(!bottomPane.myCommand.getText().isEmpty()){
		    		try{
				myController.parseAndEvaluate(bottomPane.myCommand.getText());	
		        bottomPane.myCommand.clear();
	                    }
	                    
		    	
		    	catch(Exception n){
		    		bottomPane.updateErrors(n);
		    		n.printStackTrace();
		    		
		    	}
		    }
		    }
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
