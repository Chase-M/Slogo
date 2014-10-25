package features;

import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.InfoPane;
import components.InfoPane2;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class RunButtonFeature extends Button implements Feature{
	public RunButtonFeature(Map<String, Pane> componentMap, Controller myController){
	super("Run");
	//setDisabled(true);
	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	BottomPane bottomPane = (BottomPane)componentMap.get("class components.BottomPane");
		    	InfoPane2 rightPane = (InfoPane2)componentMap.get("class components.InfoPane2");
		    	InfoPane infoPane = (InfoPane)componentMap.get("class components.InfoPane");

		    	if(!bottomPane.myCommand.getText().isEmpty()){
				myController.parseAndEvaluate(bottomPane.myCommand.getText());
		    	
		        final Button button = new Button(bottomPane.myCommand.getText());
		        final Label label = new Label(bottomPane.myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	bottomPane.myCommand.setText(button.getText());
				    }	
				    });
		      //  rightPane.variableTab.update(label2);
		      //  rightPane.historyTab.update(button);
		        infoPane.variableTab.update(label);
		        infoPane.historyTab.update(button);
		        bottomPane.myCommand.clear();
		    	}
		        //bottomPane.update();
		    }
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
