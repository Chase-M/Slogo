package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class ForCommand extends BaseMakeVariableCommand{
    
    public ForCommand(String s){
        super(s,2,2);

    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        double ans=0;
        double[] values=new double[3];
        for(int i=0; i<values.length; i++){
            values[i]=inputs.get(i+2).evaluate(workspace);
        }
        for(int i=(int) values[0]; i<values[1]; i+=(int) values[2]){
            makeVariable(inputs.get(1).getCommand().toString(),i,workspace); 
            for(int j=5; j<(inputs.size() - 1); j++){
               ans=inputs.get(j).evaluate(workspace);
           }
        }
        return ans;
    }

}
