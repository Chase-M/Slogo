package actor;

public abstract class Info {
	
	/**
	 * ActorInfo takes an actor and extracts the pertinent information for the view
	 * This is a completely passive class and exists to prevent the view from having access to update methods
	 * in the actor class
	 * @param Actor actor whose info this class will store
	 */
	public Info(Actor actor){
		
	}
}
