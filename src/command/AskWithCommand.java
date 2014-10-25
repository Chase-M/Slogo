package command;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class AskWithCommand extends Command{
    public AskWithCommand(String s){
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
