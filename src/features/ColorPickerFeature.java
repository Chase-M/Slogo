package features;

import java.util.Map;

import components.CenterPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;

public class ColorPickerFeature extends ColorPicker implements Feature {
	public ColorPickerFeature(Map<String, Pane> componentMap){
		super();
		CenterPane centerPane = (CenterPane)componentMap.get("CENTER");
		
		this.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.out.println(ColorPickerFeature.super.getValue());
				
				centerPane.setStyle("-fx-background-color: green");
				
				
			}
		});
		
		
			
			
		}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
		
	}

