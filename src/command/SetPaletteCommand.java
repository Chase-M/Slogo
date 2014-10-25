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
		int[] rgb = new int[3];
		int index = (int)inputs.get(0).evaluate(workspace);
		for(int i=0; i<rgb.length;i++){
			rgb[i] = (int)inputs.get(i+1).evaluate(workspace);
		}
		workspace.getColors().put(index, Color.rgb(rgb[0],rgb[1], rgb[2]));
		return index;
	}

}
