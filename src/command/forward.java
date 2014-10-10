package command;

import java.util.List;

import parser.Node;
import actor.Turtle;

public class forward extends Command {
	
	@Override
	public double execute(List<Node> inputs, List<Turtle> actors) {
		double distance = inputs.get(0).evaluate(actors);
		
		for(Turtle t: actors){
			t.updatePosition(distance, 0);
		}
		
		return distance;
	}

	@Override
	protected int setNumInputs() {
		return 1;
	}

}
