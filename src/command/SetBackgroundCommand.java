package command;

import java.util.List;
import exceptions.IncorrectIndexException;
import parser.Node;
import workspace.Workspace;


public class SetBackgroundCommand extends Command {

    public SetBackgroundCommand (String s) {
        super(s, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace)
                                                                  throws Exception {
        double index = inputs.get(0).evaluate(workspace);
        if (!workspace.getColors().containsKey((int)index)) {
            throw new IncorrectIndexException((int)index);
        }
        workspace.changeBackground((int)index);
        return index;
    }

}
