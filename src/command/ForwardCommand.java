package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class ForwardCommand extends Command {
	public ForwardCommand(String s){
	    super(s);
	}
	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		double distance = inputs.get(0).evaluate(turtle);
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
