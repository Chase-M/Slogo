package features;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public abstract class TextDisplayFactory extends VBox implements Feature {
	
	/**
	 * Initializes the display area for console history as well as error display
	 */
	protected GridPane myTextPane;
	private ScrollPane myScrollPane;
	public TextDisplayFactory(){
		super();
		myTextPane = new GridPane();
		myScrollPane = new ScrollPane();
		myScrollPane.setContent(myTextPane);
		myScrollPane.setPrefHeight(500);
		myScrollPane.setPrefWidth(200);
		super.getChildren().add(myScrollPane);
	}
	public void clear(){
		myTextPane.getChildren().clear();
	}

}
