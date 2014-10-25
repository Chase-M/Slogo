package command;

import java.util.ArrayList;
import java.util.List;
import parser.Node;
import workspace.Workspace;

public class ForCommand extends Command{
    
    public ForCommand(String s){
        super(s,2);
        myNumLists=2;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        double ans=0;
        List<Node> varInputs=new ArrayList<Node>();
        varInputs.add(inputs.get(1));
        varInputs.add(inputs.get(2));
        Command make=new MakeCommand("make");
        make.execute(varInputs, workspace);
        for(int i=(int) inputs.get(2).evaluate(workspace); i<inputs.get(3).evaluate(workspace); i=(int) (i+inputs.get(4).evaluate(workspace))){
            for(int j=5; j<inputs.size()-1; j++){
               varInputs.remove(1);
               varInputs.add(new Node(new ConstCommand(Integer.toString(i))));
               make.execute(varInputs,workspace); 
               ans=inputs.get(j).evaluate(workspace);
           }
        }
        return ans;
    }

}
