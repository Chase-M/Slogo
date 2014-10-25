package command;

import java.util.ArrayList;
import java.util.List;
import parser.Node;
import workspace.Workspace;

public class RepeatCommand extends BasicListCommand{

    public RepeatCommand(String s){
        super(s,2,1);
        
    }    

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        double ans=0;
        List<Node> varInputs=new ArrayList<Node>();
        varInputs.add(new Node(new VariableCommand(":repcount")));
        varInputs.add(inputs.get(1));
        Command make=new MakeCommand("make");
        make.execute(varInputs, workspace);
        for(int i=1; i<=inputs.get(0).evaluate(workspace); i++){
            varInputs.remove(1);
            varInputs.add(new Node(new ConstCommand(Integer.toString(i))));
            make.execute(varInputs,workspace); 
            for(int j=1; j<getBracketIndex(inputs); j++){
                ans=inputs.get(j).evaluate(workspace);
            }
        }
        return ans;
    }

}
