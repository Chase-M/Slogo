package mainApplication;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GUIShell extends FlowPane{
	private ToolBar myToolBar;
	private TabPane myTabPane;
	private Controller myController;
	private Stage myStage;
	public GUIShell(Controller controller, Stage stage){
		super();
		myStage = stage;
		myController = controller;
		myToolBar = new ToolBar();
		Button newButton = createNewButton();
		Button saveButton = createSaveButton();
		Button openButton = createOpenButton();
		myToolBar.setPrefWidth(1000);
		myToolBar.getItems().addAll(newButton,new Separator(), saveButton, new Separator(), openButton);
		myTabPane = new TabPane();
		
		GUI userFace = new GUI(myController, myStage.getScene());
		userFace.initiate();
		Tab first = new Tab("Untitled");
		first.setContent(userFace);
		
		first.setOnClosed(new EventHandler<Event>(){
            @Override
            public void handle (Event arg0) {
                // TODO Auto-generated method stub
                myController.removeWS(((GUI)first.getContent()).myGUIid);
                
            }
		    
		});
		first.setOnSelectionChanged(new EventHandler<Event>(){
            @Override
            public void handle (Event arg0) {
                // TODO Auto-generated method stub
                if(first.isSelected()){
                myController.setActive(((GUI)first.getContent()).myGUIid);
                }
            }
            
        });
		
		
		myTabPane.getTabs().add(first);
		this.getChildren().addAll(myToolBar, myTabPane);
	}
	
	private Button createNewButton(){
		Button b = new Button("New");
		b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				GUI newUserFace = new GUI(myController, myStage.getScene());
				newUserFace.initiate();
				Tab userTab = new Tab("Untitled");
				userTab.setContent(newUserFace);
				myTabPane.getTabs().add(userTab);
				myTabPane.getSelectionModel().select(userTab);
				
				userTab.setOnClosed(new EventHandler<Event>(){
		            @Override
		            public void handle (Event arg0) {
		                // TODO Auto-generated method stub
		                myController.removeWS(newUserFace.myGUIid);
		            }
		            
		        });
				
		        userTab.setOnSelectionChanged(new EventHandler<Event>(){
		            @Override
		            public void handle (Event arg0) {
		                // TODO Auto-generated method stub
		                if(userTab.isSelected()){
		                myController.setActive(newUserFace.myGUIid);
		                }
		            }
		            
		        });
				
			}
			
		});
		return b;
	}
	
	
	
	private Button createSaveButton(){
		Button b = new Button("Save");
	    final FileChooser fileChooser = new FileChooser();
		b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				 File file = fileChooser.showSaveDialog(myStage);
		    	 try {
					myController.saveMem(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 //myTabPane.getTabs().
				
			}
			
		});
		return b;
	}
	
	
	private Button createOpenButton(){
		Button b = new Button("Open");
	    final FileChooser fileChooser = new FileChooser();
		b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				
				GUI newUserFace = new GUI(myController, myStage.getScene());
				newUserFace.initiate();
				
				
				 File file = fileChooser.showOpenDialog(myStage);
				 
				Tab userTab = new Tab(file.getName());
				userTab.setContent(newUserFace);
				myTabPane.getTabs().add(userTab);
				myTabPane.getSelectionModel().select(userTab);
				userTab.setOnClosed(new EventHandler<Event>(){
		            @Override
		            public void handle (Event arg0) {
		                myController.removeWS(((GUI)userTab.getContent()).myGUIid);
		            }
		            
		        });
		        userTab.setOnSelectionChanged(new EventHandler<Event>(){
		            @Override
		            public void handle (Event arg0) {
		                if(userTab.isSelected()){
		                myController.setActive(((GUI)userTab.getContent()).myGUIid);
		                }
		            }
		            
		        });
		    	 try {
		    		 List<String> commands = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
		    		 StringBuilder listString = new StringBuilder();
		    		 for (String s : commands){
		    		      listString.append(s.trim()+" \n");
		    		 }
					myController.parseAndEvaluate(listString.toString());
				} catch (Exception e) {
					newUserFace.myBottomPane.updateErrors(e);
				}
				
			}
			
		});
		return b;
	}
	
}
