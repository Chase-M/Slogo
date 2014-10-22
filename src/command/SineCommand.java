package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class SineCommand extends Command {

	public SineCommand(String s){
		super(s,1); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double radians = Math.toRadians(inputs.get(0).evaluate(workspace));
		return Math.sin(radians);
	}
}
