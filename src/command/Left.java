package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class Left extends Command {

	@Override
	protected int setNumInputs() {
		return 1;
	}

	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		double angle = inputs.get(0).evaluate(actors);
		double radians = Math.toRadians(angle);
		
		
		return angle;
	}

}
