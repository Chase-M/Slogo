package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class IfElseCommand extends BasicListCommand {
    public IfElseCommand (String s) {
        super(s, 2, 2);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        checkListException(inputs);
        int index = getBracketIndex(inputs);
        double ans = 0;
        if (inputs.get(0).evaluate(workspace) != 0) {
            for (int i = 0; i < index; i++) {
                ans = inputs.get(i).evaluate(workspace);
            }
        }
        else {
            for (int i = index; i < inputs.size() - 1; i++) {
                ans = inputs.get(i).evaluate(workspace);
            }
        }
        return ans;
    }

}
