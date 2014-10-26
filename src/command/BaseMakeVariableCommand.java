package command;

import java.util.List;
import parser.Node;
import exceptions.IncorrectInputException;
import workspace.Workspace;


public abstract class BaseMakeVariableCommand extends BasicListCommand {

    public BaseMakeVariableCommand (String s, int numInputs, int numLists) {
        super(s, numInputs, numLists);
    }

    public void makeVariable (String name, double value, Workspace workspace) {
        workspace.getVariables().put(name, value);
    }
    protected void checkCorrectInput (List<Node> inputs, int i) {
        if (!(inputs.get(1).getCommand() instanceof VariableCommand) ||
            getBracketIndex(inputs) != i) { 
            throw new IncorrectInputException(toString()); 
            }
    }

}
