package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class ProductCommand extends Command {

	public ProductCommand(String s){
		super(s,2); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double prod = 1;
		for(Node n: inputs){
			prod *= n.evaluate(workspace);
		}
		return prod;

	}
}