package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import properties.PenProperties;
import workspace.Workspace;

public class PenDownCommand extends Command {
	public PenDownCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Turtle turtle=workspace.getTurtles().get(0);
		turtle.getPen().isDown = true;
		turtle.setChangedandNotify(new PenProperties(turtle.getPen()));
		return 1;
	}

}
