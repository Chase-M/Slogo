package features;

import components.CenterPane;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;

public class ColorPickerFeature extends ColorPicker implements Feature {
	public ColorPickerFeature(CenterPane centerPane){
		super();
		this.setOnAction(new EventHandler(){

			@Override
			public void handle(Event event) {
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

