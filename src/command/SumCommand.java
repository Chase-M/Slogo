package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class SumCommand extends Command {


	public SumCommand() {
		myNumInputs = 2;
	}
	public SumCommand(String s){
	   this(); 
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
