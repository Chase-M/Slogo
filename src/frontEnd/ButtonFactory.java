package frontEnd;

import javafx.scene.control.Button;

public abstract class ButtonFactory extends Button implements Feature{
	
	
	/**
	 * Initializes all the sub-methods that will create the different buttons required.
	 */
	public ButtonFactory(){
		createStartButton();
		
	}
	
	/**
	 * Example of a method that would initialize a particular button
	 */
	private void createStartButton(){
		
	}
	

}
