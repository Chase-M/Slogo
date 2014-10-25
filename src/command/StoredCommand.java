package command;

import java.util.ArrayList;
import java.util.List;
import exceptions.NotEnoughInputsException;
import parser.CommandObject;
import parser.Node;
import workspace.Workspace;

public class StoredCommand extends Command{
    
    public StoredCommand(String s){
        super(s,1);
        myNumLists=1;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        CommandObject command=workspace.getCommands().get(myString);
        List<String> names=command.getMyVarNames();
        List<Node> commands=command.getMyCommands();
        double ans=0;
        if(command.getMyNumVars()==inputs.size()-2){
            for(int i=1; i<inputs.size()-1; i++){
                Command make=new MakeCommand("make");
                Node n1=new Node(new VariableCommand(names.get(i-1)));
                Node n2=new Node(new ConstCommand(Double.toString(inputs.get(i).evaluate(workspace))));
                List<Node> varInputs=new ArrayList<Node>();
                varInputs.add(n1);
                varInputs.add(n2);
                make.execute(varInputs, workspace);
            }
        
            for(int i=0; i<commands.size()-1; i++){
                ans=commands.get(i).evaluate(workspace);
            }
        }else
            throw new NotEnoughInputsException(toString());
        return ans;
    }

}
