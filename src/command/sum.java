package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class sum extends Command {

	public sum() {
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs, List<Actor> actors) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(actors);
		}
		return sum;
	}
}
