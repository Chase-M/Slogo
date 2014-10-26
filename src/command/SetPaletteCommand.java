package command;

import java.util.List;
import javafx.scene.paint.Color;
import parser.Node;
import workspace.Workspace;


public class SetPaletteCommand extends Command {
    private static final int MY_NUM_INPUTS = 4;
    private static final int RGB_SIZE = 3;
    public SetPaletteCommand (String s) {
        super(s, MY_NUM_INPUTS);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace)
                                                                  throws Exception {
        int index = (int)inputs.get(0).evaluate(workspace);
        int[] rgb = new int[RGB_SIZE];
        for (int i = 0; i < rgb.length; i++) {
            rgb[i] = (int)inputs.get(i+1).evaluate(workspace);
        }
        workspace.getColors().put(index, Color.rgb(rgb[0], rgb[1], rgb[2]));
        return index;
    }

}
