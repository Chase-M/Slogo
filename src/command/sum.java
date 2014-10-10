package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class sum extends Command {

	public sum() {
		myNumInputs = 2;
	}

	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		double sum = 0;
		for(Node n: inputs){
			sum += n.evaluate(actors);
		}
		for(Turtle t: actors){
			t.updatePosition(0, 50, 0);
		}
		return sum;
	}
}
