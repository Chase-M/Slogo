package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class DifferenceCommand extends Command {

	public DifferenceCommand(String s){
		super(s,2); 
	}
	
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double dif = inputs.get(0).evaluate(workspace);
		for(int i = 1; i<inputs.size();i++){
			dif -= inputs.get(i).evaluate(workspace);
		}
		return dif;
	}

}
