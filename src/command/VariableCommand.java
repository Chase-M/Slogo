package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class VariableCommand extends Command{
    
    public VariableCommand(String s){
        super(s,0);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        if(workspace.getVariables().containsKey(toString()))
            return workspace.getVariables().get(toString());
        else{
            workspace.getVariables().put(toString(), 0.0);
            return 0;
        }
            
    }

}
