package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class SumCommand extends Command {

	public SumCommand() {
		myNumInputs = 2;
	}
	public SumCommand(String s){
	   this(); 
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
