package features;

import java.util.Map;

import components.CenterPane;
import mainApplication.Controller;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class PenTypeComboBoxFeature extends ComboBox implements Feature {

	public PenTypeComboBoxFeature(Map<String, Pane> componentMap, Controller myController){
		super();		
		this.getItems().addAll("solid", "dashed", "dot dashed", "dot");

		CenterPane centerPane = (CenterPane) componentMap.get("class components.CenterPane");


		this.setOnAction((event) -> {
			//System.out.println(PenTypeComboBoxFeature.this.getSelectionModel().getSelectedItem());

			String selection = new String();
			selection = (String) PenTypeComboBoxFeature.this.getSelectionModel().getSelectedItem();

			if(selection == "solid"){
				centerPane.updatePenType(1);
			}else if(selection == "dashed"){
				centerPane.updatePenType(2);
			}else if(selection == "dot dashed"){
				centerPane.updatePenType(3);
			}else if(selection == "dot"){
				centerPane.updatePenType(4);			
			}


		});



	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}




}
