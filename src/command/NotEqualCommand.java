package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class NotEqualCommand extends Command {

	public NotEqualCommand(String s){
		super(s,2);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		return (inputs.get(0).evaluate(workspace)!=inputs.get(1).evaluate(workspace))? 1:0;
	}

}
