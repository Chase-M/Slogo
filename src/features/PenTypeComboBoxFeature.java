package features;

import java.util.Map;

import mainApplication.Controller;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class PenTypeComboBoxFeature extends ComboBox implements Feature {
	
	public PenTypeComboBoxFeature(Map<String, Pane> componentMap, Controller myController){
		super();		
		this.getItems().addAll("solid", "dashed", "dot-dashed", "dot");
		
		
		this.setOnAction((event) -> {
		    System.out.println(PenTypeComboBoxFeature.this.getSelectionModel().getSelectedItem());
		   try {
			myController.parseAndEvaluate(PenTypeComboBoxFeature.this.getValue().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
		
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
