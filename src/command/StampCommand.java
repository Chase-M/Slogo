package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;


public class StampCommand extends Command {

    public StampCommand (String s) {
        super(s, 0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
       for(Turtle t: workspace.getActiveTurtles()){
           
       }
    }

}
