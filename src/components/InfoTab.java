
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


public abstract class InfoTab extends Tab implements Feature{
	
	/**
	 * Initializes the display area for console history as well as error display
	 */
	protected GridPane myTextPane;
	private ScrollPane myScrollPane;
	//private VBox drawer;
	protected int myTextIndex;
	public InfoTab(String s){
		super(s);
		setClosable(false);
		VBox drawer = new VBox();
		drawer.setStyle("-fx-background-color: #336666");
		drawer.setPrefHeight(425);
		drawer.setPrefWidth(200);
		myTextIndex = 0;
		myTextPane = new GridPane();
		myScrollPane = new ScrollPane();
		myScrollPane.setContent(myTextPane);
		myScrollPane.setPrefHeight(450);
		myScrollPane.setPrefWidth(200);
				
		drawer.getChildren().add(myScrollPane);
		VBox.setMargin(myScrollPane, new Insets(20));
		addClear(drawer);
		this.setContent(drawer);
		

	}
	public void clear(){
		myTextPane.getChildren().clear();
		myTextIndex = 0;
	}
	//Code specific to implementation
//	public void update(Node b){
//		myTextPane.add(b, 0, myTextIndex);
//		myTextIndex++;
//	}
	//Code specific to a type of tab
//	public void updateVars(Map<String, Double> vars){
//		myTextIndex = 0;
//		for(String s:vars.keySet()){
//			myTextPane.add(new Label(s), 0, myTextIndex);
//			myTextPane.add(new Label(vars.get(s).toString()), 1, myTextIndex);
//			myTextIndex++;
//		}
//	}
	private void addClear(VBox box){
		Button clear = new Button("Clear");
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				InfoTab.this.clear();
			}		
		});
		box.getChildren().add(clear);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void update(Object o){
	}

}

