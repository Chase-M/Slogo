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
	
	public ToggleGridButtonFeature(Map<String, Pane> componentMap){
		super("Grid");		
		CenterPane centerPane = (CenterPane)componentMap.get("class components.CenterPane");
		this.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub	
//				if(centerPane.referenceGrid.isGridLinesVisible()==false){
//					centerPane.referenceGrid.setGridLinesVisible(true);
//				}else if(centerPane.referenceGrid.isGridLinesVisible()==true){
//					centerPane.referenceGrid.setGridLinesVisible(false);			
//				}	
				
				centerPane.referenceGrid.setGridLinesVisible(!centerPane.referenceGrid.isGridLinesVisible());			
			}		
		});
				
	}
	 
	
	
	
	
//	private GridPane createReferenceGrid(){
//		
//		GridPane refGrid = new GridPane();
//		refGrid.setPrefSize(600,500);
//		for(int i = 0; i < 12; i++){
//		refGrid.getColumnConstraints().add(new ColumnConstraints(50));
//		}
//		for(int i = 0; i<10; i++){
//		refGrid.getRowConstraints().add(new RowConstraints(50));
//		}
//		
//		return refGrid;
//		
//	}
//	
	
	
	
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
