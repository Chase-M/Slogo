package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;


public class PenDownCommand extends Command {
    public PenDownCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        for (Turtle turtle : workspace.getActiveTurtles()) {
            turtle.getPen().setDown(true);
            turtle.changedPen();
        }
        return 1;
    }

}
