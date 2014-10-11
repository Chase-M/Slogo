package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class LeftCommand extends Command {

	public LeftCommand(String s){
		super(s);
	}
		
	@Override
	protected int setNumInputs() {
		return 1;
	}

	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		double delta = inputs.get(0).evaluate(turtle);
		double deltaRadians = Math.toRadians(delta);
		double oldAngle = turtle.getAngle();
		turtle.updatePosition(turtle.getX(), turtle.getY(), oldAngle+deltaRadians);
		return delta;
	}

}
