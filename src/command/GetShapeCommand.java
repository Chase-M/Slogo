package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class GetShapeCommand extends Command {

	public GetShapeCommand(String s) {
		super(s,0);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		List<Turtle> list = workspace.getActiveTurtles();
		Turtle turtle = list.get(list.size()-1);
		return turtle.getShape();
	}

}
