package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class PowerCommand extends Command {

    public PowerCommand (String s) {
        super(s, 2);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        double base = inputs.get(0).evaluate(workspace);
        double power = inputs.get(1).evaluate(workspace);
        return Math.pow(base, power);
    }

}
