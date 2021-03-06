package parser;

import java.util.ArrayList;
import java.util.List;
import workspace.Workspace;
import command.Command;


public class Node {

    private List<Node> myChildren;
    private Command myCommand;

    /**
     * Node class takes a command to put in a tree for parsing
     * 
     * @param com This nodes Command
     */
    public Node (Command com) {
        myChildren = new ArrayList<>();
        myCommand = com;
    }

    /**
     * returns the value of the this command and executes this command as well
     * as all its children
     * 
     * @return
     * @throws Exception
     */
    public double evaluate (Workspace workspace) throws Exception {
        return myCommand.execute(myChildren, workspace);
    }

    /**
     * adds a child node which will be another command or int that this command needs to
     * execute
     * ie a forward command would need a child with an int parameter
     */
    public void addChild (Node node) {
        myChildren.add(node);
    }

    /**
     * returns this nodes command
     * 
     * @return
     */
    public Command getCommand () {
        return myCommand;
    }

    public List<Node> getChildren () {
        return myChildren;
    }

    public String toString () {
        String string = "";
        for (Node n : myChildren) {
            string = string + n.toString();
        }
        string = " " + getCommand().toString() + string;
        return string;
    }
}
