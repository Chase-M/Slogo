package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public abstract class Command {
	
	int myNumInputs;
	/**
	 * Creates a command that will act on the list of actors given
	 * @param actors
	 */
	public Command(){
		myNumInputs = 0;
	}
	
	
	/**
	 * Returns the number of inputs for the specific command
	 */
	public int getNumInputs(){
		return myNumInputs;
	}
	
	/**
	 * Executes the command on the list of actors provided
	 * based on the inputs given 
	 * and returns the appropriate integer value
	 * 
	 * @param inputs List of inputs for the specific command
	 * @return appropriate int based on the type of command
	 */
	public abstract double execute(List<Node> inputs, List<Actor> actors);
	
}
