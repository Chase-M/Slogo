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

        Controller controller = new Controller(stage);
        GUI userFace = new GUI(controller);
        // controller.updateGUI(userFace);
        userFace.initiate();
        userFace.initiateKeyPress(s);

        /**
         * Below is prelim code for creating multiple tabs
         */
        /*
         * ToolBar tools = new ToolBar(); FlowPane pane = new
         * FlowPane(Orientation.HORIZONTAL); tools.setPrefWidth(1000);
         * tools.getItems().addAll(new Button("New"), new Button("Open"), new
         * Button("Save")); pane.getChildren().add(tools); Controller
         * controller2 = new Controller(stage); GUI userFace2 = new
         * GUI(controller2);
         * 
         * userFace2.initiate(); TabPane tabPane = new TabPane(); Tab tab = new
         * Tab(); tab.setText("new tab"); tab.setContent(userFace);
         * tabPane.getTabs().add(tab); Tab tab2 = new Tab();
         * tab2.setText("new tab 2"); tab2.setContent(userFace2);
         * tabPane.getTabs().add(tab2); pane.getChildren().add(tabPane);
         * root.getChildren().add(pane);
         */
        root.getChildren().add(userFace);
        stage.setScene(s);
        stage.setResizable(false);
        stage.show();
    }
}
