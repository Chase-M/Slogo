package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class QuotientCommand extends Command {

    public QuotientCommand (String s) {
        super(s, 2);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        double q = inputs.get(0).evaluate(workspace);

        q = q / inputs.get(1).evaluate(workspace);
        if (Double.isInfinite(q)) {
            return 0;
        }

        return q;
    }
}
