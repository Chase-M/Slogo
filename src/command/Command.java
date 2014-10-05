package command;

import java.util.List;

import actor.Actor;

public abstract class Command {
	
	/**
	 * Returns the number of inputs for the specific command
	 */
	public int getNumInputs(){
		return 0;
	}
	
	/**
	 * Executes the command on the list of actors provided
	 * based on the inputs given 
	 * and returns the appropriate integer value
	 * 
	 * @param inputs List of inputs for the specific command
	 * @param actors List of actors to be acted on
	 * @return appropriate int based on the type of command
	 */
	public abstract int execute(List<Node> inputs, List<Actor> actors);
	
}
