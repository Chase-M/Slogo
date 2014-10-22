package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class ForwardCommand extends Command {
	public ForwardCommand(String s){
	    super(s);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double distance = inputs.get(0).evaluate(workspace);
		Turtle turtle=workspace.getTurtles().get(0);
		double newX = turtle.getX() + Math.cos(turtle.getAngle())*distance;
		double newY = turtle.getY() + Math.sin(turtle.getAngle())*distance;
		turtle.updatePosition(newX,newY,turtle.getAngle());
		
		return distance;
	}

	@Override
	protected int setNumInputs() {
		return 1;
	}

}
