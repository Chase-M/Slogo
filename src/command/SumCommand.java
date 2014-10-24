package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class SumCommand extends Command {

	public SumCommand(String s){
	   super(s,2); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(workspace);
		}
		return sum;
	}
}
