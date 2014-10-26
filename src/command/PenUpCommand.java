package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;


public class PenUpCommand extends Command {
    public PenUpCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        for (Turtle turtle : workspace.getActiveTurtles()) {
            turtle.getPen().setDown(false);
            turtle.changedPen();
        }
        return 0;
    }

}
