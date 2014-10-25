package command;

import java.util.List;
import parser.Node;
import workspace.Workspace;


public abstract class Command {

    protected int myNumInputs;
    protected int myListFlag;
    protected String myString;

    /**
     * Creates a command that will act on the list of actors given
     * 
     * @param actors
     */
    public Command (String s) {
        myListFlag = 0;
        myString = s;
    }
    
    protected Command(String s, int i){
    	this(s);
    	myNumInputs = i;
    }

    /**
     * Returns the number of inputs for the specific command
     */
    public int getNumInputs (Node node) {
        if (node!=null && node.getCommand() instanceof ListStartCommand) {
            myListFlag++;
        }
        
        if (myListFlag > 0) {
            if ( checkListExit(node)){
                return 0;
            }else return Integer.MAX_VALUE;
        }
        else return myNumInputs;
    }
    public boolean checkListExit(Node node){
       return  node.getCommand() instanceof GroupEndCommand;
    }
    public String toString () {
        return myString;
    }
    public boolean isList(){
        return myListFlag==1 ? true:false;
    }
    /**
     * Executes the command on the list of actors provided
     * based on the inputs given
     * and returns the appropriate integer value
     * 
     * @param inputs List of inputs for the specific command
     * @return appropriate int based on the type of command
     * @throws Exception TODO
     */
    public abstract double execute (List<Node> inputs, Workspace workspace) throws Exception;
    
}
