package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class TurtlesCommand extends Command {
    public TurtlesCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        return workspace.getTurtles().size();
    }
}
