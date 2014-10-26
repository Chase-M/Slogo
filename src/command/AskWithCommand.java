package command;

import java.util.ArrayList;
import java.util.List;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;


public class AskWithCommand extends BaseMultiTurtleCommand {
    public AskWithCommand (String s) {
        super(s, 2, 2);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {

        checkListException(inputs);
        int index = getBracketIndex(inputs);
        double ans = 0;
        List<Turtle> oldList = workspace.getActiveTurtles();
        List<Turtle> list = new ArrayList<Turtle>();
        list.add(workspace.getTurtles().get(0));
        for (Turtle t : workspace.getTurtles().values()) {
            list.set(0, t);
            tell(getIds(list), workspace);
            if (inputs.get(1).evaluate(workspace) != 0) {
                for (int i = index; i < inputs.size() - 1; i++) {
                    ans = inputs.get(i).evaluate(workspace);

                }
            }
        }
        tell(getIds(oldList), workspace);

        return ans;
    }

}
