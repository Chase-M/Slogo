package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class SetPositionCommand extends Command {

	public SetPositionCommand(String s){
		super(s);
	}
	
	
	@Override
	protected int setNumInputs() {
		return 2;
	}

	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		double newX = inputs.get(0).evaluate(turtle);
		double newY = inputs.get(1).evaluate(turtle);
		turtle.updatePosition(newX,newY,turtle.getAngle());
		return 0;
	}

}
