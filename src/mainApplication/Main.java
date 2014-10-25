

package mainApplication;


import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args){
		launch(args);
	}


	private Scene initiate(Group root){
		ResourceBundle numResources = ResourceBundle.getBundle("resources/constants/numbers");
		int sceneHeight = Integer.parseInt(numResources.getString("Scene_height"));
		int sceneWidth = Integer.parseInt(numResources.getString("Scene_width"));
		return new Scene(root, sceneWidth, sceneHeight, Color.GREY);
	}	

	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage = new Stage();
		Group root = new Group();
		Scene s = initiate(root);

		Controller controller = new Controller(stage);
		GUI userFace = new GUI(controller);
		//controller.updateGUI(userFace);
		userFace.initiate();
		userFace.initiateKeyPress(s);

/**
 * Below is prelim code for creating multiple tabs		
 */
		
		
/*		GUI userFace2 = new GUI();
		
		userFace2.initiate();
		TabPane tabPane = new TabPane();
		 Tab tab = new Tab();
		 tab.setText("new tab");
		 tab.setContent(userFace);
		 tabPane.getTabs().add(tab);
		 Tab tab2 = new Tab();
		 tab2.setText("new tab 2");
		 tab2.setContent(userFace2);
		 tabPane.getTabs().add(tab2);
		root.getChildren().add(tabPane);
		*/
		root.getChildren().add(userFace);
			stage.setScene(s);
			stage.setResizable(false);
			stage.show();
	}
}
