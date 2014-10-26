package command;

/**
 * @author Timesh Patel, Chase Malik
 */
import java.util.List;
import parser.Node;
import exceptions.IncorrectInputException;
import workspace.Workspace;


public abstract class BaseMakeVariableCommand extends BasicListCommand {
    /**
     * A command sub hierarchy for all commands that needed to make their own variables
     * 
     * @param s
     * @param numInputs
     * @param numLists
     */
    public BaseMakeVariableCommand (String s, int numInputs, int numLists) {
        super(s, numInputs, numLists);
    }

    /**
     * makes a variable in the workspace map
     * 
     * @param name
     *        name of variable
     * @param value
     *        value of variable
     * @param workspace
     */
    public void makeVariable (String name, double value, Workspace workspace) {
        workspace.getVariables().put(name, value);
    }

    /**
     * Checks inputs so when making a variable a proper variable name and node
     * are in the correct location and that it has the right number of inputs
     * 
     * @param inputs
     * @param i
     */
    protected void checkCorrectInput (List<Node> inputs, int i) {
        if (!(inputs.get(1).getCommand() instanceof VariableCommand) ||
            getBracketIndex(inputs) != i) { throw new IncorrectInputException(toString()); }
    }

}
