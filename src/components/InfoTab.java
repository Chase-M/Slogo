
package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
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
	protected VBox myDrawer;
	//private VBox myDrawer;
	protected int myTextIndex;
	protected Controller myController;
	public InfoTab(String s, Controller c){
		super(s.substring(0, s.length()-3));
		myController = c;
		setClosable(false);
		myDrawer = new VBox();
		myDrawer.setStyle("-fx-background-color: #336666");
		myDrawer.setPrefHeight(425);
		myDrawer.setPrefWidth(200);
		myTextIndex = 0;
		myTextPane = new GridPane();
		myScrollPane = new ScrollPane();
		myScrollPane.setContent(myTextPane);
		myScrollPane.setPrefHeight(450);
		myScrollPane.setPrefWidth(200);
				
		myDrawer.getChildren().add(myScrollPane);
		VBox.setMargin(myScrollPane, new Insets(20));
	//	addClear(myDrawer);
		this.setContent(myDrawer);
		

	}
	public void clear(){
		myTextPane.getChildren().clear();
		myTextIndex = 0;
	}

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

