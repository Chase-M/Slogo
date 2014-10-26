package features;

import java.util.Map;

import components.CenterPane;
import components.LeftPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class ToggleGridButtonFeature extends Button implements Feature {
	
	/**
	 * Toggles upon click the visiblity of the grid in center pane
	 * @param componentMap
	 */
	
	public ToggleGridButtonFeature(Map<String, Pane> componentMap){
		super("Grid");		
		CenterPane centerPane = (CenterPane)componentMap.get("class components.CenterPane");
		this.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {

				centerPane.referenceGrid.setGridLinesVisible(!centerPane.referenceGrid.isGridLinesVisible());			
			}		
		});
				
	}
	 
	

	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
