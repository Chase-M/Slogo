package components;

import features.Feature;
import features.SettingsBar;
import features.Toolbar;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class TopPane extends FlowPane implements Feature {
	
	Toolbar myToolbar;
	public SettingsBar mySettingsBar;
	
	public TopPane(){
		super(Orientation.VERTICAL);
		myToolbar = new Toolbar();
		myToolbar.setPrefWidth(1000); //eliminate this num
		myToolbar.setPrefHeight(33);
		mySettingsBar = new SettingsBar();
		this.getChildren().add(myToolbar);
		this.getChildren().add(mySettingsBar);
		this.setPrefHeight(76);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void addItems(Node ... n){
		myToolbar.getItems().addAll(n);
	}
	
}
