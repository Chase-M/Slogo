package command;

import java.util.ArrayList;
import java.util.List;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class AskCommand extends BasicListCommand{
    public AskCommand(String s){
        super(s,2,2);
        
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        int index=getBracketIndex(inputs);
        List<Turtle> tellList=workspace.getActiveTurtles();
        List<Node> oldList=new ArrayList<Node>();
        oldList.add(new Node(new ConstCommand("0")));
        for(Turtle t: tellList){
            oldList.add(new Node(new ConstCommand(Integer.toString(t.getID()))));
        }
        oldList.add(new Node(new ConstCommand("0")));
        List<Node> list=new ArrayList<Node>();
        list.add(new Node(new ConstCommand("0")));
        for(int i=1; i<index;i++){
            list.add(inputs.get(i));
            
        }
        list.add(new Node(new ConstCommand("0")));
        
        Command tell=new TellCommand("tell");
        tell.execute(list, workspace);
               double ans=0;
        for(int i=index; i<inputs.size()-1; i++){
            ans=inputs.get(i).evaluate(workspace);
       
        }

        tell.execute(oldList, workspace);
       
        return ans;
    }
}
