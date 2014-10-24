package command;

import java.util.List;

import javafx.geometry.Point2D;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class HomeCommand extends Command {
	
	private static final double HOMEX = 0;
	private static final double HOMEY = 0;
	public HomeCommand(String s){
	    super(s,0);
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Turtle turtle=workspace.getTurtles().get(0);
		Point2D oldP = turtle.getPoint();
		turtle.updatePosition(HOMEX,HOMEY,turtle.getAngle());
		
		return oldP.distance(HOMEX,HOMEY);
	}

}
