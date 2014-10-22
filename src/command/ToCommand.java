package command;

import java.util.ArrayList;
import java.util.List;
import parser.CommandObject;
import parser.Node;
import workspace.Workspace;

public class ToCommand extends Command{
    
    public ToCommand(String s){
        super(s,2);
        myNumLists=1;
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        List<Node> varList=inputs.get(0).getChildren();
        List<String> names=new ArrayList<String>();
        int numVars=varList.size()-2;
        for(int i=1; i<varList.size()-1; i++){
            names.add(varList.get(i).getCommand().toString());
        } 
        List<Node> commands=new ArrayList<Node>(inputs);
        commands.remove(0);
        workspace.getCommands().put(inputs.get(0).getCommand().toString(), new CommandObject(numVars, names, commands));
        return 0;
    }

}
