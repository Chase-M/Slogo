package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public abstract class Command {

    protected int myNumInputs;
    private int myListFlag;
    protected int myNumLists;
    protected String myString;

    /**
     * Creates a command that will act on the list of actors given
     * 
     * @param actors
     */
    public Command () {
        myNumInputs = setNumInputs();
        myNumLists=0;
        myListFlag = 0;
    }

    public Command (String s) {
        this();
        myString = s;
    }

    protected abstract int setNumInputs ();

    /**
     * Returns the number of inputs for the specific command
     */
    public int getNumInputs (Node node) {
        if (node!=null && node.getCommand() instanceof ListStartCommand) {
            myListFlag++;
        }
        
        if (myListFlag > 0) {
            if ((node.getCommand() instanceof ListEndCommand && (myNumLists=myNumLists-1)==0) || node.getCommand() instanceof GroupEndCommand){
                return 0;
            }else return Integer.MAX_VALUE;
        }
        else return myNumInputs;
    }

    public String toString () {
        return myString;
    }

    /**
     * Executes the command on the list of actors provided
     * based on the inputs given
     * and returns the appropriate integer value
     * 
     * @param inputs List of inputs for the specific command
     * @return appropriate int based on the type of command
     */
    public abstract double execute (List<Node> inputs, Workspace workspace);

}
