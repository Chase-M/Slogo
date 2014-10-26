package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;


public abstract class RotateCommand extends Command implements PositionInterface {

    protected static final int LEFT = 1;
    protected static final int RIGHT = -1;

    protected RotateCommand (String s, int i) {
        super(s, i);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace)
                                                                  throws Exception {
        double delta = inputs.get(0).evaluate(workspace);
        double deltaRadians = Math.toRadians(delta) * getDirection();
        for (Turtle turtle : workspace.getActiveTurtles()) {
            double oldAngle = turtle.getAngle();
            turtle.updatePosition(turtle.getX(), turtle.getY(), oldAngle + deltaRadians);
        }
        return delta;
    }
}
