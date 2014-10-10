package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class LessCommand extends Command{

	public LessCommand() {
		super();
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs, List<Actor> actors) {
		return (inputs.get(0).evaluate(actors)<inputs.get(1).evaluate(actors))? 1:0;
	}
}
