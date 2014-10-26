package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class RightCommand extends RotateCommand {

	public RightCommand(String s){
		super(s,1);
	}

	@Override
	public int getDirection() {
		return RIGHT;
	}


}
