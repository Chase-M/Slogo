package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class MakeCommand extends Command{
    

    public MakeCommand(String s){
        super(s);
    }
    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        String name=inputs.get(0).getCommand().toString();
        workspace.getVariables().put(name, inputs.get(1).evaluate(workspace));
        return 0;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 2;
    }

}
