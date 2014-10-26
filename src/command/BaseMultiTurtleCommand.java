package command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;

public abstract class BaseMultiTurtleCommand extends BasicListCommand{

    public BaseMultiTurtleCommand (String s, int numInputs, int numLists) {
        super(s, numInputs, numLists);
        // TODO Auto-generated constructor stub
    }
    protected List<Integer> getIds(List<Turtle> turtles){
      List<Integer> list=new ArrayList<Integer>();
      for(Turtle t: turtles){
          list.add(t.getID());
      }
      return list;
    }
    protected List<Integer> getIdsList(List<Node> inputs, Workspace workspace) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < getBracketIndex(inputs); i++) {
            list.add((int) inputs.get(i).evaluate(workspace));
        }
        return list;
    }
    protected void tell(List<Integer> Ids, Workspace workspace){
        Map<Integer,Turtle> map = workspace.getTurtles();
        Set<Integer> myIds = new HashSet<>();
        for(Integer id : Ids){
        if(!map.containsKey(id)){
            workspace.createTurtle(id);
        }
        myIds.add(id);
        }
        for(Integer i: map.keySet()){
                map.get(i).setActive(myIds.contains(i));
        }
    }
}
