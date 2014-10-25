package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class TangentCommand extends Command {
	public static final double TOLERANCE = 0.000000001;

	public TangentCommand(String s){
		super(s,1); 
	}
	@Override
	public double execute(List<Node> inputs, Workspace workspace) throws Exception {
		double radians = Math.toRadians(inputs.get(0).evaluate(workspace));
		if(Math.cos(radians) < TOLERANCE && Math.cos(radians) > -TOLERANCE) return 0;
		else return Math.tan(radians);
	}
}
