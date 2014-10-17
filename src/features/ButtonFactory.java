package features;

import java.util.List;

import parser.Parser;

import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public abstract class ButtonFactory extends Button implements Feature{
	
	
	/**
	 * Initializes all the sub-methods that will create the different buttons required.
	 */
	
	public ButtonFactory(List<Pane> myComponents, Parser parser){
			super("Run");
			Pane bottomPane;
			Pane centerPane;
			Pane topPane;
			Pane leftPane;
			Pane rightPane;
			   this.setPrefSize(100, 20);
			   for(Pane p: myComponents){
				   if(p instanceof BottomPane){
					   bottomPane = p;
				   }
				   if(p instanceof CenterPane){
					   centerPane = p;
				   }
				   if(p instanceof LeftPane){
					   leftPane = p;
				   }
				   if(p instanceof RightPane){
					   rightPane = p;
				   }
				   if(p instanceof TopPane){
					   topPane = p;
				   }
			   }
	}
	
	/**
	 * Example of a method that would initialize a particular button
	 */
	private void createStartButton(){
		
	}
	

}
