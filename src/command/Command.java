package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public abstract class Command {

	protected int myNumInputs;
	protected int myListFlag;
	protected String myString;

	/**
	 * Creates a command with the given string as its name
	 * 
	 * @param s
	 *            name of command
	 */
	public Command(String s) {
		myListFlag = 0;
		myString = s;
	}

	/**
	 * Creates a command with the given string as its name and the given number
	 * of inputs
	 * 
	 * @param s
	 *            name of command
	 * @param numInputs
	 *            number of inputs for the command
	 */
	protected Command(String s, int numInputs) {
		this(s);
		myNumInputs = numInputs;
	}

	/**
	 * Returns the number of inputs for the specific command If it is a bracket
	 * command then it checks the next node to see if it is an end bracket
	 * 
	 * @param node
	 * @return number of inputs
	 */
	public int getNumInputs(Node node) {
		if (node != null && node.getCommand() instanceof ListStartCommand) {
			myListFlag++;
		}

		if (myListFlag > 0) {
			if (checkListExit(node)) {
				return 0;
			} else {
				return Integer.MAX_VALUE;
			}
		} else {
			return myNumInputs;
		}
	}

	/**
	 * Returns if the node is an end bracket
	 * 
	 * @param node
	 *            holding next command
	 * @return if the node is an end bracket
	 */
	protected boolean checkListExit(Node node) {
		return node.getCommand() instanceof GroupEndCommand;
	}

	/**
	 * Returns the commands name
	 * @return command's name
	 */
	public String toString() {
		return myString;
	}
	/**
	 * Returns the current command is in a list
	 * @return boolean if the current command is in a list
	 */
	public boolean isList() {
		return (myListFlag == 1);
	}

	/**
	 * Executes the command in the workspace provided based on the inputs
	 * given and returns the appropriate double value
	 * 
	 * @param inputs List of inputs for the specific command
	 * @param workspace the command is being executed in
	 * @return appropriate double based on the type of command
	 * @throws Exception if the command was unable to execute properly given the inputs it was given
	 */
	public abstract double execute(List<Node> inputs, Workspace workspace)
			throws Exception;

}
