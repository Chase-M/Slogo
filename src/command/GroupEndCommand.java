package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class GroupEndCommand extends Command{
    public GroupEndCommand(String s){
        super(s,0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

}
