package command;

import java.util.List;

import parser.Node;
import actor.Actor;
import actor.Turtle;

public class SumCommand extends Command {

	public SumCommand() {
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(actors);
		}
		return sum;
	}
}
