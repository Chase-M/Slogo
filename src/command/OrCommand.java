package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class OrCommand extends Command {

	public OrCommand(String s){
		super(s,2);
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		return (inputs.get(0).evaluate(workspace)!=0 || inputs.get(1).evaluate(workspace)!=0)? 1:0;
	}


}
