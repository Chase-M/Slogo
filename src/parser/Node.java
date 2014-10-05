package parser;

public class Node {
    /**
     * Node class takes a command to puts in a tree for parsing
     * @param com This nodes Command
     */
    public Node(Command com){
        
    }
    /**
     * returns the value of the this command and executes this command as well 
     * as all its children 
     * @return
     */
    public int evaluate(){
        return 0;
    }
    /**
     * adds a child node which will be another command or int that this command needs to 
     * execute
     * ie a forward command would need a child with an int parameter 
     */
    public void addChild(){
        
    }
    /**
     * returns this nodes command
     * @return
     */
    public Command getCommand(){
        return null;
    }
}
