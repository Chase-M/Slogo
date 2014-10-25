package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import properties.PenProperties;
import workspace.Workspace;

public class PenDownCommand extends Command {
	public PenDownCommand(String s){
		super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		for(Turtle turtle :workspace.getActiveTurtles()){
			turtle.getPen().setDown(true);
			turtle.changedPen();
		}
		return 1;
	}

}
