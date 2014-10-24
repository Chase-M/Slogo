package command;

import java.util.ArrayList;
import java.util.List;
import parser.Node;
import workspace.Workspace;

public class DoTimesCommand extends Command{

    public DoTimesCommand (String s) {
        // TODO Auto-generated constructor stub
        super(s,1);
        myNumLists=2;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        List<Node> varInputs=new ArrayList<Node>();
        varInputs.add(inputs.get(1));
        varInputs.add(new Node(new ConstCommand("0")));
        Command make=new MakeCommand("make");
        make.execute(varInputs, workspace);
        int index=0;
        for(int i=0; i<inputs.size(); i++ ){
            if(inputs.get(i).getCommand() instanceof ListEndCommand){
                index=i;
                break;
            }
        }
        double ans=0;
        for(int j=1; j<=inputs.get(2).evaluate(workspace); j++){
            varInputs.remove(1);
            varInputs.add(new Node(new ConstCommand(Integer.toString(j))));
            make.execute(varInputs,workspace); 
        for(int i=index; i<inputs.size()-1; i++){
            ans=inputs.get(i).evaluate(workspace);
        }
        }
        return ans;
    }

}
