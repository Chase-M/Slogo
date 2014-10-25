package command;

import java.util.ArrayList;
import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class AskCommand extends Command{
    public AskCommand(String s){
        super(s,2);
        myNumLists=2;
        
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) {
        // TODO Auto-generated method stub
        int index=0;
        for(int i=0; i<inputs.size(); i++ ){
            if(inputs.get(i).getCommand() instanceof ListEndCommand){
                index=i;
                break;
            }
        }
        List<Turtle> tellList=workspace.getActiveTurtles();
        List<Node> list=new ArrayList<Node>();
        for(int i=1; i<index;i++){
            list.add(inputs.get(i));
        }
        Command tell=new TellCommand("tell");
        tell.execute(list, workspace);
        double ans=0;
        for(int i=index; i<inputs.size()-1; i++)
            ans=inputs.get(i).evaluate(workspace);
        
        list.clear();
        for(Turtle t: tellList){
            list.add(new Node(new ConstCommand(Integer.toString(t.getID()))));
        }
        tell.execute(list, workspace);
        return ans;
    }
}
