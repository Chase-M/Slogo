package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class SetHeadingCommand extends Command {
	public SetHeadingCommand(String s){
		super(s,1);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		double heading = inputs.get(0).evaluate(workspace);
		for(Turtle turtle :workspace.getActiveTurtles()){
			turtle.updatePosition(turtle.getX(),turtle.getY(),Math.toRadians(heading));
		}
		return heading;
	}

}
