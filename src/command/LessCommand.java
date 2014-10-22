package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class LessCommand extends Command{

	public LessCommand(String s){
		super(s);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		return (inputs.get(0).evaluate(workspace)<inputs.get(1).evaluate(workspace))? 1:0;
	}

	@Override
	protected int setNumInputs() {
		return 2;
	}
}
