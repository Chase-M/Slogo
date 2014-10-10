package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public abstract class Command {
	/**
	 * Creates a command that will act on the list of actors given
	 * @param actors
	 */
	public Command(List<Actor> actors){
		
	}
	
	
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
	 * @return appropriate int based on the type of command
	 */
	public abstract int execute(List<Node> inputs);
	
}
