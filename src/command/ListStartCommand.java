package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class ListStartCommand extends Command {

    public ListStartCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        return 0;
    }

}
