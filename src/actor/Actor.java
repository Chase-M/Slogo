package actor;

import view.View;

public abstract class Actor {
	
	View myView;
	/**
	 * Creates actor that belongs to a specific view
	 * The class is used to store information and can update the view
	 * 
	 * @param view
	 */
	public Actor(View view){
		myView = view;
	}
	
	public abstract void updateView();
	
}
