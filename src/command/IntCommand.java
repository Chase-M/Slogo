package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class IntCommand extends Command {

	int myValue;
	public IntCommand(String s){
		super();
		myValue = Integer.parseInt(s);
		myNumInputs = 0;

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
