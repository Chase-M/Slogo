package features;

import java.util.Map;

import mainApplication.Controller;
import components.CenterPane;
import components.LeftPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ColorPickerFeature extends ColorPicker implements Feature {
	
	/**
	 * Creates a Color Picker which changes the background to selected color
	 * @param componentMap: Map containing our collection of Panes
	 */

	public ColorPickerFeature(Map<String, Pane> componentMap){
		super();
		CenterPane centerPane = (CenterPane)componentMap.get("class components.CenterPane");
		LeftPane leftPane = ((LeftPane)componentMap.get("class components.LeftPane"));
		this.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {				
				centerPane.setStyle("-fx-background-color: #"	
									+ColorPickerFeature.super.getValue().toString().substring(2));			
			}
		});
	
		}

    @Override
    public void update () {

    }

}
