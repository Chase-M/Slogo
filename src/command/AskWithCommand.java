package command;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class AskWithCommand extends BasicListCommand{
    public AskWithCommand(String s){
        super(s,2,2);
  
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        // TODO Auto-generated method stub
        checkListException(inputs);
        int index=getBracketIndex(inputs);
        double ans=0;
        for(Turtle t: workspace.getTurtles().values()){
            tell(t, workspace);
            if(inputs.get(1).evaluate(workspace)!=0){
                for(int i=index; i<inputs.size()-1; i++){
                    ans=inputs.get(i).evaluate(workspace);
               
                }
            }
        }
        return ans;
    }
    private void tell(Turtle turtle, Workspace workspace){
        Map<Integer,Turtle> map = workspace.getTurtles();
        Set<Integer> ids = new HashSet<>();
        int id = turtle.getID();
        if(!map.containsKey(id)){
            workspace.createTurtle(id);
        }
        ids.add(id);
        
        for(Integer i: map.keySet()){
                map.get(i).setActive(ids.contains(i));
        }
    }
}
