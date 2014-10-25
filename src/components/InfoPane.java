package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import features.Feature;
import features.TextDisplayFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sun.misc.Queue;


public class InfoPane extends FlowPane implements Feature {
	
	/**
	 * Initializes the display area for console history as well as error display
	 */
	//private TabPane myTabPane;
	public InfoTab historyTab;
	public InfoTab variableTab;

	public InfoPane(String s, String t){
		super(Orientation.VERTICAL);
		TabPane tabPane = new TabPane();
		setStyle("-fx-background-color: #336666");
		setPrefHeight(500);
		setPrefWidth(200);
		historyTab = new InfoTab(s);
		variableTab = new InfoTab(t);		
		tabPane.getTabs().add(historyTab);
		tabPane.getTabs().add(variableTab);
		ToolBar myToolBar = initiateToolBar(tabPane);		
		this.getChildren().addAll(myToolBar, tabPane);
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	private ToolBar initiateToolBar(TabPane tabPane){
		Map<CheckBox, Tab> checkMap = new HashMap<CheckBox, Tab>();
		for(Tab t: tabPane.getTabs()){
			CheckBox cb = new CheckBox();
			cb.setSelected(true);
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> arg0,
						Boolean arg1, Boolean arg2) {
					if(arg1){tabPane.getTabs().remove(t);}
					else{tabPane.getTabs().add(t);}
				}
		    });
			checkMap.put(cb, t);
		}
		ToolBar toolBar = new ToolBar();
		toolBar.getItems().addAll(checkMap.keySet());
		return toolBar;
	}

}

