package features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import actor.Turtle;
import parser.Node;
import parser.Parser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveButtonFeature extends Button implements Feature{
	public SaveButtonFeature(Controller myController){
	super("Save");
    final FileChooser fileChooser = new FileChooser();

	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//myController.
		    	//fileChooser.
		    	 File file = fileChooser.showSaveDialog(myController.myStage);
		    	 myController.saveMem(file);
		        //bottomPane.update();*/
		    	 
		    } 
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
