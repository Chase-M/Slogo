package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VarsTab extends InfoTab{
	Map<String, Double> myVars;
	public VarsTab(String s, Controller c) { //Maybe change this to not have controller, give to "Save button" instead
		super(s, c);		
		myVars = new HashMap<String, Double>();
		Button edit = new Button("Edit");
		myDrawer.getChildren().add(edit);
		edit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				setTabEditable(edit);
			}
			
		});
	}
	@Override
	public void update(Object o){
//		try{
		myVars = (Map<String,Double>) o;
		myTextPane.getChildren().clear();
	myTextIndex = 0;
	//if(!myVars.equals(null)){
	for(String s:myVars.keySet()){
		myTextPane.add(new Label(s), 0, myTextIndex);
		myTextPane.add(new Label(myVars.get(s).toString()), 1, myTextIndex);
		myTextIndex++;
	//}
	}
//		}
//	catch(NullPointerException e){
//		System.out.println("null n stuff");
//	}
	
}
//		}
	private void setTabEditable(Button edit){
		Map<String, Double> newVarsMap = new HashMap<String, Double>();
		myTextPane.getChildren().clear();
		myTextIndex = 0;
		for(String s:myVars.keySet()){
			myTextPane.add(new Label(s), 0, myTextIndex);
			TextField editable = new TextField(myVars.get(s).toString());
			myTextPane.add(editable, 1, myTextIndex);
			myTextIndex++;
		}	
		myDrawer.getChildren().remove(edit);
		Button save = new Button("Save");
		myDrawer.getChildren().add(save);
		save.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				//Iterator iter = myTextPane.getRowConstraints().iterator();
				//myTextPane.getChildren()
				List<String> labelList = new ArrayList<String>();
				List<Double> textList = new ArrayList<Double>();
				for(Node i:myTextPane.getChildren()){
					if(i instanceof Label){
						labelList.add(((Label)i).getText());
					}
					if(i instanceof TextField){
						textList.add(Double.parseDouble(((TextField) i).getText()));
					}
				}
					for(int k = 0; k< labelList.size(); k++){
						newVarsMap.put(labelList.get(k), textList.get(k));
					}
				//	newVarsMap.put(myTextPane.getRowConstraints().iterator(), 50.);
				for(String s:newVarsMap.keySet()){
					if(newVarsMap.get(s)!=myVars.get(s)){
						try {
							myController.parseAndEvaluate(String.format("set %s %s", s, newVarsMap.get(s)));
							VarsTab.this.update(myController.getVariables());
						} catch (Exception e) {
							System.out.println("failed");
						}
					}
				}
				
				myDrawer.getChildren().remove(save);
				myDrawer.getChildren().add(edit);
			}
		});
		
	}


}
