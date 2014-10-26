package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class RemainderCommand extends Command {
    public RemainderCommand (String s) {
        super(s, 2);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        double mod = inputs.get(1).evaluate(workspace);
        return inputs.get(0).evaluate(workspace) % mod;
    }
}
