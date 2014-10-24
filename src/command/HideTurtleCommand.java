package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class HideTurtleCommand extends Command {
	public HideTurtleCommand(String s){
		super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		for(Turtle turtle :workspace.getActiveTurtles()){
			turtle.setShowing(false);
		}
		return 0;
	}

}
