package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class MinusCommand extends Command {

	public MinusCommand(String s){
		super(s,1); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		return -inputs.get(0).evaluate(workspace);
	}

}
