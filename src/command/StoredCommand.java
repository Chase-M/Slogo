package command;

import java.util.ArrayList;
import java.util.List;
import parser.CommandObject;
import parser.Node;
import workspace.Workspace;

public class StoredCommand extends Command{
    
    public StoredCommand(String s){
        super(s);
        myNumLists=1;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        CommandObject command=workspace.getCommands().get(myString);
        List<String> names=command.getMyVarNames();
        List<Node> commands=command.getMyCommands();
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
            for(Node n: commands){
                n.evaluate(workspace);
            }
        }
        return 0;
    }

}
