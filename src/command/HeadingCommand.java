package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;


public class HeadingCommand extends Command {
    public HeadingCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        List<Turtle> turtles = workspace.getActiveTurtles();
        Turtle turtle = turtles.get(turtles.size() - 1);
        return Math.toDegrees(turtle.getAngle());
    }

}
