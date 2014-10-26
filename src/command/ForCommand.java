package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public class ForCommand extends BaseMakeVariableCommand {

    private static final int INPUTS_SIZE = 3;
    private static final int START_COMMANDS = 5;

    public ForCommand (String s) {
        super(s, 2, 2);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        checkListException(inputs);
        checkCorrectInput(inputs, START_COMMANDS);
        double ans = 0;
        double[] values = new double[INPUTS_SIZE];
        for (int i = 0; i < values.length; i++) {
            values[i] = inputs.get(i + 2).evaluate(workspace);
        }
        for (int i = (int)values[0]; i < values[1]; i += (int)values[2]) {
            makeVariable(inputs.get(1).getCommand().toString(), i, workspace);
            for (int j = START_COMMANDS; j < (inputs.size() - 1); j++) {
                ans = inputs.get(j).evaluate(workspace);
            }
        }
        return ans;
    }


}
