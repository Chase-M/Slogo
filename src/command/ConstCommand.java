package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class ConstCommand extends Command {

	double myValue;
	public ConstCommand(String s){
		super(s);
		myValue = Double.parseDouble(s);
		myNumInputs = 0;

	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		return myValue;
	}

	@Override
	protected int setNumInputs() {
		return 0;
	}

}
