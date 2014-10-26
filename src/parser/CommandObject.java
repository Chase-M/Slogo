package parser;
/**
 * @author Timesh Patel, Chase Malik
 */
import java.util.List;


public class CommandObject {
    private int myNumVars;
    private List<String> myVarNames;
    private List<Node> myCommands;
    /**
     * represents a stored command has a list of varnames, num inputs, and commands
     * @param num
     * @param names
     * @param commands
     */
    public CommandObject (int num, List<String> names, List<Node> commands) {
        myNumVars = num;
        myVarNames = names;
        myCommands = commands;
    }

    public List<String> getMyVarNames () {
        return myVarNames;
    }

    public int getMyNumVars () {
        return myNumVars;
    }

    public List<Node> getMyCommands () {
        return myCommands;
    }

    public String toString () {
        String string = "[ ";
        for (String s : myVarNames) {
            string = " " + string + s + " ";
        }
        string = string + " ]  ";
        for (Node n : myCommands) {
            string = " " + string + " " + n.toString();
        }
        return string;
    }
}
