package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class ClearScreenCommand extends Command {

	public ClearScreenCommand(String s) {
		super(s,0);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double ans = workspace.getTurtles().get(0).getPoint().distance(0,0);
		workspace.clear();		
		return ans;
	}

}
