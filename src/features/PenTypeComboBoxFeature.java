package features;

import java.util.Map;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class PenTypeComboBoxFeature extends ComboBox implements Feature {
	
	public PenTypeComboBoxFeature(Map<String, Pane> componentMap){
		super();		
		this.getItems().addAll("Normal", "Dashed", "Dot Dashed", "Dot");
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
