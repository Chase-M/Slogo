package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class DoTimesCommand extends BaseMakeVariableCommand {

    public DoTimesCommand (String s) {
        super(s, 1, 2);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        checkListException(inputs);
        int index = getBracketIndex(inputs);
        double ans = 0;
        for (int j = 1; j <= inputs.get(2).evaluate(workspace); j++) {
            makeVariable(inputs.get(1).getCommand().toString(), j, workspace);

            for (int i = index; i < inputs.size() - 1; i++) {
                ans = inputs.get(i).evaluate(workspace);
            }
        }
        return ans;
    }

}
