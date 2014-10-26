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
		    	InfoPane rightPane = (RightPane)componentMap.get("class components.RightPane");
		    	InfoPane infoPane = (LeftPane)componentMap.get("class components.LeftPane");

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
		        paramMap.put("class components.VarsTab", myController.getVariables());
		        paramMap.put("class components.TurtlesTab", myController.getVariables());
		        paramMap.put("class components.ColorsTab", myController.getColors());
		      //  System.out.println(myController.getColors());
		        
		        paramMap.put("class components.SavedTab", new Button("here"));
		        List<InfoTab> list = infoPane.myTabs;
				for(InfoTab t:list){
					//t.clear();
					//System.out.println(paramMap.get(t.getClass().toString()));
					t.update(paramMap.get(t.getClass().toString()));
					
				}
				List<InfoTab> list2 = rightPane.myTabs;
				for(InfoTab t:list2){
					//t.clear();
					//System.out.println(paramMap.get(t.getClass().toString()));
					t.update(paramMap.get(t.getClass().toString()));
					
				}
		      //  infoPane.variableTab.updateVars(myController.getVariables());
		        bottomPane.myCommand.clear();
	                    }
	                    
		    	
		    	catch(Exception n){
		    		bottomPane.updateErrors(n);
		    		n.printStackTrace();
		    		
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
