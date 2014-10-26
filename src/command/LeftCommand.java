package command;

import java.util.List;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class LeftCommand extends RotateCommand {

	public LeftCommand(String s){
		super(s,1);
	}

	@Override
	public int getDirection() {
		return LEFT;
	}


}
