package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class ConstCommand extends Command {

	double myValue;
	public ConstCommand(String s){
		super(s,0);
		myValue = Double.parseDouble(s);

	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		return myValue;
	}

}
