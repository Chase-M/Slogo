package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;


public class TowardsCommand extends Command {
    public TowardsCommand (String s) {
        super(s, 2);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        double pointX = inputs.get(0).evaluate(workspace);
        double pointY = inputs.get(1).evaluate(workspace);
        double ans = 0;
        for (Turtle turtle : workspace.getActiveTurtles()) {
            double curX = turtle.getX();
            double curY = turtle.getY();
            double deltaX = pointX - curX;
            double deltaY = pointY - curY;
            double radians = Math.atan2(deltaY, deltaX);
            turtle.updatePosition(curX, curY, radians);
            ans = Math.toDegrees(radians);
        }
        return ans;
    }

}
