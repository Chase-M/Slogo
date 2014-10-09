package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class LessCommand extends Command{

	public LessCommand(List<Actor> actors) {
		super(actors);
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs) {
		return (inputs.get(0).evaluate()<inputs.get(1).evaluate())? 1:0;
	}

}
