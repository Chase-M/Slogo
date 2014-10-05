package buttonInput;

import features.Feature;

public abstract class ButtonFactory implements Feature{
	
	
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
