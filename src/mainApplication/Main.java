package mainApplication;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	public Main(){
		
	}
	
	
	public static void main(String[] args){
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {
		Controller controller = new Controller();
		stage.setScene(controller.getScene());
		stage.show();
	}

}
