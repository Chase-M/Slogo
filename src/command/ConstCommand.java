package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class ConstCommand extends Command {

	int myValue;
	public ConstCommand(String s){
		super();
		myValue = Integer.parseInt(s);
		myNumInputs = 0;

	}
	
	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		return myValue;
	}

	@Override
	protected int setNumInputs() {
		return 0;
	}

}
