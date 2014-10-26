package features;

import java.util.Map;

import components.CenterPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AnimateButtonFeature extends Button implements Feature {
	
	/**
	 * Creates Button that when selected, updates whether or not animation is turned on
	 * @param componentMap: Map containing our collection of Panes
	 */
    public AnimateButtonFeature (Map<String, Pane> componentMap) {
        super("Animate");
        CenterPane centerPane = (CenterPane) componentMap.get("class components.CenterPane");
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent event) {
                centerPane.updateAnimate(!centerPane.animate);
            }

        });

    }

    @Override
    public void update () {
        // TODO Auto-generated method stub

    }

}
