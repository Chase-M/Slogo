package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class BackCommand extends MoveCommand {
	public BackCommand(String s){
		super(s,1);
	}

	@Override
	public int getDirection() {
		return BACKWARD;
	}

}
