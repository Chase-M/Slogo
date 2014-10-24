package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class ShowingQueryCommand extends Command {
	public ShowingQueryCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Turtle turtle=workspace.getTurtles().get(0);
		return (turtle.isShowing())? 1:0;
	}

}
