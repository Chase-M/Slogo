package features;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

public class OpenButtonFeature extends Button implements Feature{
	public OpenButtonFeature(Controller myController){
	super("Open");
    final FileChooser fileChooser = new FileChooser();

	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//myController.
		    	 File file = fileChooser.showOpenDialog(myController.myStage);
		    	                 if (file != null) {
                 // openFile(file);
          //    	myController.
              	String fileString = null;
					try {
						fileString = Files.readAllLines(Path.get(file.getPath())).toString();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("IOException");
					}
              	try {
						myController.parseAndEvaluate(fileString);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Other");
					}
              	
              }
		    }
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
