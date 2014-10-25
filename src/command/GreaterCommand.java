package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class GreaterCommand extends Command {

	public GreaterCommand(String s){
		super(s,2);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		return (inputs.get(0).evaluate(workspace)>inputs.get(1).evaluate(workspace))? 1:0;
	}

}
