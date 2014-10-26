package components;

import features.Feature;
import features.SettingsBar;
import features.Toolbar;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;

public class TopPane extends FlowPane implements Feature {
	
	Toolbar myToolbar;
	public SettingsBar mySettingsBar;
	private SettingsBar myPenBar;
	
	public TopPane(){
		super(Orientation.VERTICAL);
	//	myToolbar = new Toolbar();
	//	myToolbar.setPrefWidth(1000); //eliminate this num
	//	myToolbar.setPrefHeight(33);
		mySettingsBar = new SettingsBar();
		myPenBar = new SettingsBar();
	//	this.getChildren().add(myToolbar);
		this.getChildren().addAll(mySettingsBar, myPenBar);
		this.setPrefHeight(76);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void addItems(Node ... n){
		myPenBar.getItems().addAll(n);
	}
	
	public void addSlider(Slider slider){
		mySettingsBar.getItems().add(slider);
	}
	
}
