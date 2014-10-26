package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class NotCommand extends Command {

    public NotCommand (String s) {
        super(s, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        return (inputs.get(0).evaluate(workspace) == 0) ? 1 : 0;
    }

}
