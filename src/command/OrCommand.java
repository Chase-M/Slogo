package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class OrCommand extends Command {

	public OrCommand(String s){
		super(s,2);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double ans = 0;
		// Must execute all commands
		for(Node n : inputs){
			if(n.evaluate(workspace) != 0)
				ans = 1;
		}
		return ans;
	}


}
