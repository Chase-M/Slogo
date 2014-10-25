package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class RightCommand extends Command {

	public RightCommand(String s){
		super(s,1);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		double delta = inputs.get(0).evaluate(workspace);
		double deltaRadians = Math.toRadians(delta);
		for(Turtle turtle :workspace.getActiveTurtles()){
			double oldAngle = turtle.getAngle();
			turtle.updatePosition(turtle.getX(), turtle.getY(), oldAngle-deltaRadians);
		}
		return delta;
	}

}
