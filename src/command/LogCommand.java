package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class LogCommand extends Command {

    public LogCommand (String s) {
        super(s, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        return Math.log(inputs.get(0).evaluate(workspace));
    }

}
