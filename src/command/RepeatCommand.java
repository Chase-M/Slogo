package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class RepeatCommand extends BaseMakeVariableCommand{

    public RepeatCommand(String s){
        super(s,2,1);
        
    }    

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        double ans=0;
        for(int i=1; i<=inputs.get(0).evaluate(workspace); i++){
            makeVariable(":repcount",i,workspace); 
            for(int j=1; j<getBracketIndex(inputs); j++){
                ans=inputs.get(j).evaluate(workspace);
            }
        }
        return ans;
    }

}
