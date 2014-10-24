package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import features.Feature;
import features.TextDisplayFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sun.misc.Queue;


public class LeftPane extends VBox implements Feature {
	
	/**
	 * Initializes the display area for console history as well as error display
	 */
	private TabPane myTabPane;
	private Tab tabTemp;
	private Tab tabTemp2;
	private Map<String, Double> myVariables;
	public TempTabForPanes tempTabThing;
	public TempTabForPanes tempTabThing2;

	public LeftPane(){
		super();
		myTabPane = new TabPane();
		
		//myVariables = variables;
		setStyle("-fx-background-color: #336666");
		setPrefHeight(500);
		setPrefWidth(200);
		ToolBar myToolBar = initiateToolBar();		
		super.getChildren().addAll(myToolBar, myTabPane);
		Pane paneTemp = new Pane();
		tempTabThing = new TempTabForPanes();
		tempTabThing2 = new TempTabForPanes();
		//paneTemp.getChildren().add(tempTabThing);
		tabTemp = new Tab("Variables");
		tabTemp2 = new Tab("Commands");
		tabTemp.setContent(tempTabThing);
		tabTemp.setClosable(false);
		myTabPane.getTabs().add(tabTemp);
		tabTemp2.setContent(tempTabThing2);
		tabTemp2.setClosable(false);
		myTabPane.getTabs().add(tabTemp2);
	}
	
/*	public void updateVars(Map<String, Double> vars){
		myTextIndex = 0;
		for(String s:vars.keySet()){
			myTextPane.add(new Label(s), 0, myTextIndex);
			myTextPane.add(new Label(vars.get(s).toString()), 1, myTextIndex);
			myTextIndex++;
		}
	}
	*/

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	private ToolBar initiateToolBar(){
		ToolBar toolBar = new ToolBar();
		CheckBox cb1 = new CheckBox();
		cb1.setSelected(true);
		cb1.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				//LeftPane.this.getChildren().add(new Label(arg2.toString()));
				if(arg1){myTabPane.getTabs().remove(tabTemp);}
				else{myTabPane.getTabs().add(tabTemp);}
				
			}
	    });
		
		CheckBox cb2 = new CheckBox();
		cb2.setSelected(true);
		cb2.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				//LeftPane.this.getChildren().add(new Label(arg2.toString()));
				if(arg1){myTabPane.getTabs().remove(tabTemp2);}
				else{myTabPane.getTabs().add(tabTemp2);}
				
			}
	    });
		
		CheckBox cb3 = new CheckBox();
		toolBar.getItems().addAll(cb1, cb2, cb3);
		return toolBar;
	}

}

