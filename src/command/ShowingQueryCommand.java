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
		List<Turtle> turtles=workspace.getActiveTurtles();
		Turtle turtle = turtles.get(turtles.size()-1);
		return (turtle.isShowing())? 1:0;
	}

}
