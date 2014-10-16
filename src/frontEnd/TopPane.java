package frontEnd;

import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;

public class TopPane extends FlowPane implements Feature {
	
	Toolbar myToolbar;
	SettingsBar mySettingsBar;
	
	public TopPane(){
		super(Orientation.VERTICAL);
		myToolbar = new Toolbar();
		myToolbar.setPrefWidth(1000); //eliminate this num
		myToolbar.setPrefHeight(33);
		mySettingsBar = new SettingsBar();
		this.getChildren().add(myToolbar);
		this.getChildren().add(mySettingsBar);
		this.setPrefHeight(105);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
