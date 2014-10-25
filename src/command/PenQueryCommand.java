package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class PenQueryCommand extends Command {
	public PenQueryCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		List<Turtle> turtles=workspace.getActiveTurtles();
		Turtle turtle = turtles.get(turtles.size()-1);
		return (turtle.getPen().isDown)? 1:0;
	}

}
