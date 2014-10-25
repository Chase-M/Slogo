package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class SetBackgroundCommand extends Command {

	public SetBackgroundCommand(String s) {
		super(s,1);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		double index = inputs.get(0).evaluate(workspace);
		workspace.changeBackground((int)index);
		return index;
	}

}
