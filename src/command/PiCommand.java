package command;

import java.util.List;

import parser.Node;
import workspace.Workspace;

public class PiCommand extends Command {

	public PiCommand(String s){
		super(s,0); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		return Math.PI;
	}

}
