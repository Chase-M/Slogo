package frontEnd;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;


public class BottomPane extends HBox implements Feature {
	public final TextArea myCommand;
	
	public BottomPane(){
	    setPrefWidth(1000);
	    setPadding(new Insets(15, 12, 15, 12));
	    setSpacing(10);    
	    myCommand = new TextArea();
	    myCommand.setPrefRowCount(3);
	    setStyle("-fx-background-color: #336699;");
	    this.getChildren().add(myCommand);
	}
	public void updateButton(Button run){
	   	   this.getChildren().add(run);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
