package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public abstract class TurtleCommand extends Command {

	public TurtleCommand(String s) {
		super(s);
	}
}
