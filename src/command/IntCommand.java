package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class IntCommand extends Command {

	int myValue;
	public IntCommand(int i){
		super();
		myValue = i;
	}
	
	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		return myValue;
	}

	@Override
	protected int setNumInputs() {
		return 0;
	}

}
