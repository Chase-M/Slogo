package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class LessCommand extends Command{

	public LessCommand(String s){
		super(s);
	}
	
	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		return (inputs.get(0).evaluate(turtle)<inputs.get(1).evaluate(turtle))? 1:0;
	}

	@Override
	protected int setNumInputs() {
		return 2;
	}
}
