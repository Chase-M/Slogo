package mainApplication;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    private Scene initiate (Group root) {
        ResourceBundle numResources = ResourceBundle
                .getBundle("resources/constants/numbers");
        int sceneHeight = Integer.parseInt(numResources
                .getString("Scene_height"));
        int sceneWidth = Integer
                .parseInt(numResources.getString("Scene_width"));
        return new Scene(root, sceneWidth, sceneHeight, Color.GREY);
    }

    @Override
    public void start (Stage stage) throws Exception {
        Group root = new Group();
        Scene s = initiate(root);
        stage.setScene(s);
		Controller controller = new Controller();
		GUIShell shell = new GUIShell(controller, stage);

		root.getChildren().add(shell);
	//	GUI userFace = new GUI(controller, stage.getScene());
	//	userFace.initiate();
	//	root.getChildren().add(userFace);
			stage.setResizable(false);
			stage.show();
	}
}