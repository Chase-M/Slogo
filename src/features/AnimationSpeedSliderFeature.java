package features;

import java.util.Map;

import components.BottomPane;
import components.CenterPane;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import mainApplication.Controller;

public class AnimationSpeedSliderFeature extends Slider implements Feature {
	
	/**
	 * Creates slider that sets the speed of animation
	 * @param componentMap: Map containing our collection of Panes
	 */
	public AnimationSpeedSliderFeature(Map<String, Pane> componentMap){	
		super();
		this.setMin(50);
		this.setMax(4000
				);
		this.setValue(1);
		CenterPane centerPane = (CenterPane)componentMap.get("class components.CenterPane");
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {				
				centerPane.updateAnimationSpeed(AnimationSpeedSliderFeature.this.getValue());				
			}
			
		});
	
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

}
