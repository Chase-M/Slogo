package command;

import java.util.List;

import exceptions.IncorrectIndexException;
import actor.Turtle;
import parser.Node;
import properties.PenProperties;
import workspace.Workspace;

public class SetPenColorCommand extends Command {

	public SetPenColorCommand(String s) {
		super(s,1);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		double index = inputs.get(0).evaluate(workspace);
		if(!workspace.getColors().containsKey((int)index))
			throw new IncorrectIndexException((int)index);
		for(Turtle turtle :workspace.getActiveTurtles()){
			turtle.getPen().setColorIndex((int)index);
			turtle.changedPen();
		}
		return index;
	}

}
