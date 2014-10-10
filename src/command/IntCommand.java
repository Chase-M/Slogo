package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class IntCommand extends Command {

	int myValue;
	public IntCommand(int i){
		super();
		myValue = i;
		myNumInputs = 0;
	}
	
	@Override
	public double execute(List<Node> inputs, List<Actor> actors) {
		return myValue;
	}

}
