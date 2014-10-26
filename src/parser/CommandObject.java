package parser;

import java.util.List;


// TODO rename
public class CommandObject {
    private int myNumVars;
    private List<String> myVarNames;
    private List<Node> myCommands;

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
