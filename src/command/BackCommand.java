package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class BackCommand extends Command {
	public BackCommand(String s){
		super(s,1);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		double distance = inputs.get(0).evaluate(workspace);
		for(Turtle turtle :workspace.getActiveTurtles()){
			double newX = turtle.getX() - Math.cos(turtle.getAngle())*distance;
			double newY = turtle.getY() - Math.sin(turtle.getAngle())*distance;
			turtle.updatePosition(newX,newY,turtle.getAngle());
		}

		return distance;
	}

}
