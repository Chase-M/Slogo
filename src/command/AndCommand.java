package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class AndCommand extends Command {

	public AndCommand(String s){
		super(s,2);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		double ans = 1;
		// Must execute all commands
		for(Node n : inputs){
			if(n.evaluate(workspace) == 0)
				ans = 0;
		}
		return ans;

	}

}
