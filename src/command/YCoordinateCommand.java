package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class YCoordinateCommand extends Command {
	public YCoordinateCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Turtle turtle=workspace.getTurtles().get(0);
		return turtle.getY();
	}

}
