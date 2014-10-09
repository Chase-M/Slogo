package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class SumCommand extends Command {

	public SumCommand(List<Actor> actors) {
		super(actors);
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate();
		}
		return sum;
	}
}
