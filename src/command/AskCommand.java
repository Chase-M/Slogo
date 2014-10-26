package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;


public class AskCommand extends BaseMultiTurtleCommand {
    public AskCommand (String s) {
        super(s, 2, 2);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        int index = getBracketIndex(inputs);
        List<Turtle> oldList = workspace.getActiveTurtles();
        tell(getIdsList(inputs,workspace), workspace);
        double ans = 0;
        for (int i = index; i < inputs.size() - 1; i++) {
            ans = inputs.get(i).evaluate(workspace);
        }
        tell(getIds(oldList), workspace);
        return ans;
    }
}
