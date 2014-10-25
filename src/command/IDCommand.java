package command;

import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class IDCommand extends Command{

    public IDCommand (String s) {
        super(s,0);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        double ans=0;
        for(Turtle t: workspace.getActiveTurtles()){
            ans=t.getID();
        }
        return ans;
    }

}
