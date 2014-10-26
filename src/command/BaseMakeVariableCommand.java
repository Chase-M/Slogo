package command;

import workspace.Workspace;


public abstract class BaseMakeVariableCommand extends BasicListCommand {

    public BaseMakeVariableCommand (String s, int numInputs, int numLists) {
        super(s, numInputs, numLists);
    }

    public void makeVariable (String name, double value, Workspace workspace) {
        workspace.getVariables().put(name, value);
    }

}
