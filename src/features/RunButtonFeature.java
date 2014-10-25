package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.InfoPane;
import components.InfoPane2;
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
		    		try{
				myController.parseAndEvaluate(bottomPane.myCommand.getText());
		    	
		        final Button button = new Button(bottomPane.myCommand.getText());
		        //final Label label = new Label(bottomPane.myCommand.getText());
		        button.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	bottomPane.myCommand.setText(button.getText());
				    }	
				    });
		      //  rightPane.variableTab.update(label2);
		      //  rightPane.historyTab.update(button);
		     //   infoPane.variableTab.update(label);
		      //  infoPane.historyTab.update(button);
		       // infoPane.variableTab.clear();
		        
		        Map<String, Object> paramMap = new HashMap<String, Object>();
		        paramMap.put("class components.HistoryTab", button);
		        paramMap.put("class components.VariableTab", myController.getVariables());
		        paramMap.put("class components.InfoTab", myController.getVariables());
		        
		        List<InfoTab> list = infoPane.myTabs;
				for(InfoTab t:list){
					//t.clear();
					t.update(paramMap.get(t.getClass().toString()));
					
				}
		      //  infoPane.variableTab.updateVars(myController.getVariables());
		        bottomPane.myCommand.clear();
		    	}
		    	
		    	catch(Exception n){
		    		bottomPane.updateErrors(n);
		    		
		    	}
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
