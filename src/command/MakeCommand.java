package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;

public class MakeCommand extends Command{
    

    public MakeCommand(String s){
        super(s,2);
    }
    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        String name=inputs.get(0).getCommand().toString();
        workspace.getVariables().put(name, inputs.get(1).evaluate(workspace));
        return inputs.get(1).evaluate(workspace);
    }

}
