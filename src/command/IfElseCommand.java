package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class IfElseCommand extends Command {
    public IfElseCommand(String s){
        super(s,2);
        myNumLists=2;
    }
    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        int index=0;
        for(int i=0; i<inputs.size(); i++ ){
            if(inputs.get(i).getCommand() instanceof ListEndCommand){
                index=i;
                break;
            }
        }
        if(inputs.get(0).evaluate(workspace)!=0){
            for(int i=0; i<index; i++)
                inputs.get(i).evaluate(workspace);
        }else{
            for(int i=index; i<inputs.size(); i++)
                inputs.get(i).evaluate(workspace);
        }
        return 0;
    }

}
