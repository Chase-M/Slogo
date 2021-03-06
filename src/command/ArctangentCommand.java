package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class ArctangentCommand extends Command {

    public ArctangentCommand (String s) {
        super(s, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        double radians = Math.atan(inputs.get(0).evaluate(workspace));
        return Math.toDegrees(radians);
    }
}
