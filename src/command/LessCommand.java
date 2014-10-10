package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class LessCommand extends Command{

	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		return (inputs.get(0).evaluate(actors)<inputs.get(1).evaluate(actors))? 1:0;
	}

	@Override
	protected int setNumInputs() {
		return 2;
	}
}
