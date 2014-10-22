package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class ForCommand extends Command{
    
    public ForCommand(String s){
        super(s);
        myNumLists=2;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        for(int i=(int) inputs.get(1).evaluate(workspace); i<inputs.get(2).evaluate(workspace); i=(int) (i+inputs.get(3).evaluate(workspace))){
           for(int j=4; j<inputs.size(); j++){ 
               inputs.get(j).evaluate(workspace);
           }
        }
        return 0;
    }

}
