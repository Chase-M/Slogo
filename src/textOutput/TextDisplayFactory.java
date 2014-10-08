package textOutput;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import features.Feature;

public abstract class TextDisplayFactory extends VBox implements Feature {
	
	/**
	 * Initializes the display area for console history as well as error display
	 */
	GridPane myTextPane;
	public ScrollPane myScrollPane;
	public TextDisplayFactory(){
		super();
		myTextPane = new GridPane();
		myScrollPane = new ScrollPane();
		myScrollPane.setContent(myTextPane);
		super.getChildren().add(myScrollPane);
	}
	public void clear(){
		myTextPane.getChildren().clear();
	}

}
