package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import properties.PenProperties;
import workspace.Workspace;

public class PenUpCommand extends Command {
	public PenUpCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Turtle turtle=workspace.getTurtles().get(0);
		turtle.getPen().isDown = false;
		turtle.setChangedandNotify(new PenProperties(turtle.getPen()));
		return 0;
	}

}
