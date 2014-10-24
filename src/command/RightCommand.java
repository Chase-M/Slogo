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
	public double execute(List<Node> inputs, Workspace workspace) {
		double delta = inputs.get(0).evaluate(workspace);
		double deltaRadians = Math.toRadians(delta);
		Turtle turtle=workspace.getTurtles().get(0);
		double oldAngle = turtle.getAngle();
		turtle.updatePosition(turtle.getX(), turtle.getY(), oldAngle-deltaRadians);
		return delta;
	}

}
