package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class SetShapeCommand extends Command {

	public SetShapeCommand(String s) {
		super(s,1);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		double shape = inputs.get(0).evaluate(workspace);
		for(Turtle turtle :workspace.getActiveTurtles()){
			turtle.changeShape((int)shape);
		}
		return shape;
	}

}
