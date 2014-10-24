package command;

import java.util.List;
import actor.Turtle;
import javafx.geometry.Point2D;
import parser.Node;
import workspace.Workspace;

public class SetPositionCommand extends Command {

	public SetPositionCommand(String s){
		super(s,2);
	}


	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		double newX = inputs.get(0).evaluate(workspace);
		double newY = inputs.get(1).evaluate(workspace);
		Point2D oldP = null;
		for(Turtle turtle :workspace.getActiveTurtles()){
			oldP = turtle.getPoint();
			turtle.updatePosition(newX,newY,turtle.getAngle());
		}
		return oldP.distance(newX,newY);
	}

}
