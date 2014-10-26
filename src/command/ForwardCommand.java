package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class ForwardCommand extends MoveCommand {
	public ForwardCommand(String s){
		super(s,1);
	}
	
	@Override
	public int getDirection() {
		return FORWARD;
	}

}
