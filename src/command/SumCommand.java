package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class SumCommand extends Command {

	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(actors);
		}
		return sum;
	}

	@Override
	protected int setNumInputs() {
		return 2;
	}
}
