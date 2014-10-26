package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class TellCommand extends BaseMultiTurtleCommand {

    public TellCommand (String s) {
        super(s, 1, 1);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        checkListException(inputs);
        tell(getIdsList(inputs, workspace), workspace);
        return inputs.get(inputs.size() - 2).evaluate(workspace);
    }

}
