package command;
/**
 * @author Timesh Patel, Chase Malik
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import parser.Node;
import workspace.Workspace;
import actor.Turtle;


public abstract class BaseMultiTurtleCommand extends BasicListCommand {
    /**
     *  command sub hierarchy for commands that involve multiple turtles 
     *  and setting particular ones active
     * @param s
     * @param numInputs
     * @param numLists
     */
    public BaseMultiTurtleCommand (String s, int numInputs, int numLists) {
        super(s, numInputs, numLists);
    }
    /**
     * returns list of Integers corresponding to ids from a list of turtles 
     * @param turtles
     * @return
     */
    protected List<Integer> getIds (List<Turtle> turtles) {
        List<Integer> list = new ArrayList<Integer>();
        for (Turtle t : turtles) {
            list.add(t.getID());
        }
        return list;
    }
    /**
     * returns a list of Integers from a list of inputs from the beginning 
     * until the first end bracket
     * @param inputs
     * @param workspace
     * @return
     * @throws Exception
     */
    protected List<Integer> getIdsList (List<Node> inputs, Workspace workspace) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < getBracketIndex(inputs); i++) {
            list.add((int)inputs.get(i).evaluate(workspace));
        }
        return list;
    }
    /**
     * takes a list of integers corresponding to ids and tells 
     * the workspace to set those turtles to active or to
     * create them
     * @param ids
     * @param workspace
     */
    protected void tell (List<Integer> ids, Workspace workspace) {
        Map<Integer, Turtle> map = workspace.getTurtles();
        Set<Integer> myIds = new HashSet<>();
        for (Integer id : ids) {
            if (!map.containsKey(id)) {
                workspace.createTurtle(id);
            }
            myIds.add(id);
        }
        for (Integer i : map.keySet()) {
            map.get(i).setActive(myIds.contains(i));
        }
    }
}
