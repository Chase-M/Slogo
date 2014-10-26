package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public abstract class MoveCommand extends Command implements PositionInterface{

	protected static final int FORWARD = 1;
	protected static final int BACKWARD = -1;
	protected static final int LEFT = 1;
	protected static final int RIGHT = -1;
	
	protected MoveCommand(String s, int i) {
		super(s, i);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		double distance = inputs.get(0).evaluate(workspace);
		int direction = getDirection();
		for(Turtle turtle :workspace.getActiveTurtles()){
			double newX = turtle.getX() + Math.cos(turtle.getAngle())*distance*direction;
			double newY = turtle.getY() + Math.sin(turtle.getAngle())*distance*direction;
			turtle.updatePosition(newX,newY,turtle.getAngle());
		}
		return distance;
	}
}
