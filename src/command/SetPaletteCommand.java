package command;

import java.util.List;

import javafx.scene.paint.Color;
import parser.Node;
import workspace.Workspace;

public class SetPaletteCommand extends Command {

	public SetPaletteCommand(String s) {
		super(s,4);
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace)
			throws Exception {
		int index = (int)inputs.get(0).evaluate(workspace);
		int r = (int)inputs.get(1).evaluate(workspace);
		int g = (int)inputs.get(2).evaluate(workspace);
		int b = (int)inputs.get(3).evaluate(workspace);
		workspace.getColors().put(index, Color.rgb(r, g, b));
		return index;
	}

}
