

package mainApplication;


import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
		Controller controller = new Controller();
		GUI userFace = new GUI(controller);
		userFace.initiate();
		root.getChildren().add(userFace);
		stage.setScene(s);
		stage.show();	
	}
}
