package command;

import java.util.List;

import parser.Node;
import actor.Actor;

public class IntCommand extends Command {

	int myValue;
	public IntCommand(List<Actor> actors, int i){
		super(actors);
		myValue = i;
		myNumInputs = 0;
	}
	
	@Override
	public double execute(List<Node> inputs) {
		// TODO Auto-generated method stub
		return myValue;
	}

}
