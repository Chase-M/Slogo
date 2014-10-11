package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class SumCommand extends Command {

	public SumCommand(String s){
	   super(s); 
	}
	@Override
	public double execute(List<Node> inputs, Turtle turtle) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(turtle);
		}
		return sum;
	}

	@Override
	protected int setNumInputs() {
		return 2;
	}
}
