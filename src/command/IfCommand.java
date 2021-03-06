package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class IfCommand extends BasicListCommand {

    public IfCommand (String s) {
        super(s, 2, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {

        checkListException(inputs);
        double ans = 0;
        if (inputs.get(0).evaluate(workspace) != 0) {
            for (int i = 1; i < inputs.size() - 1; i++) {
                ans = inputs.get(i).evaluate(workspace);
            }
        }
        return ans;
    }
}
