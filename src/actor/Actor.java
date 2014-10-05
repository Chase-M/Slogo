package actor;

public abstract class Actor {
	/**
	 * Creates actor that belongs to a specific view
	 * The class is used to store information and can update the view
	 * 
	 * @param view
	 */
	public Actor(View view){
		
	}
	
	public abstract void updateView();
	
}
