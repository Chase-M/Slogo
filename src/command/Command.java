package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public abstract class Command {
	
	int myNumInputs;
	String myString;
	/**
	 * Creates a command that will act on the list of actors given
	 * @param actors
	 */
	public Command(){
		myNumInputs = setNumInputs();
	}
	public Command(String s){
	    this();
	    myString = s;
	}
	
	protected abstract int setNumInputs();


	/**
	 * Returns the number of inputs for the specific command
	 */
	public int getNumInputs(){
		return myNumInputs;
	}
	
	public String toString(){
		return myString;
	}
	
	/**
	 * Executes the command on the list of actors provided
	 * based on the inputs given 
	 * and returns the appropriate integer value
	 * 
	 * @param inputs List of inputs for the specific command
	 * @return appropriate int based on the type of command
	 */
	public abstract double execute(List<Node> inputs, List<Turtle> actors);
	
}
