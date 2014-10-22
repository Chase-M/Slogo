package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class TangentCommand extends Command {


	public TangentCommand(String s){
		super(s,1); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double radians = Math.toRadians(inputs.get(0).evaluate(workspace));
		if(Math.cos(radians) == 0) return 0;
		else return Math.tan(radians);
	}
}
