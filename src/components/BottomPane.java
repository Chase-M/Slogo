package components;


import features.Feature;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
	    Label errorDisplay = new Label("ERRORS:\ntest");
	    errorDisplay.setStyle("-fx-background-color: #ffffff;"
	    		+ "-fx-border-width: 2;-fx-border-color: black;");
	    errorDisplay.setPadding(new Insets(15, 12, 15, 12));
	    errorDisplay.setPrefWidth(300);
	    TabPane tabs = new TabPane();
	    //tabs.setStyle(arg0);
	    //tabs.set
	    Tab errorsTemp = new Tab("test");
	    errorsTemp.setClosable(false);
	    errorsTemp.setContent(errorDisplay);
	    tabs.getTabs().add(errorsTemp);
	    this.getChildren().addAll(myCommand, tabs);//errorDisplay);
	}
	public void updateButton(Button run){
	   	   this.getChildren().add(run);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
