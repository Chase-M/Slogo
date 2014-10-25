package features;

import java.util.Map;

import mainApplication.Controller;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PenWidthSliderFeature extends Slider implements Feature {
	public PenWidthSliderFeature(Map<String, Pane> componenetMap, Controller myController){
		super();
		this.setMin(0);
		this.setMax(10);
		this.setValue(1);			
		this.setShowTickLabels(true);
		this.setShowTickMarks(true);
		this.setMajorTickUnit(5);
		this.setMinorTickCount(5);
		this.setBlockIncrement(1);
		
		
			this.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					String num = Double.toString(PenWidthSliderFeature.this.getValue());	
					
				try {
					myController.parseAndEvaluate("setpensize "+num);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					
				}
			});
		

		
		
	}
	
	
	
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
