package parser;

import java.util.List;

// TODO rename
public class CommandObject {
    private int myNumVars;
    private List<String> myVarNames;
    private List<Node> myCommands;
    public CommandObject(int num, List<String> names, List<Node> commands){
        setMyNumVars(num);
        setMyVarNames(names);
        setMyCommands(commands);
    }
    public List<String> getMyVarNames () {
        return myVarNames;
    }
    public void setMyVarNames (List<String> myVarNames) {
        this.myVarNames = myVarNames;
    }
    public int getMyNumVars () {
        return myNumVars;
    }
    public void setMyNumVars (int myNumVars) {
        this.myNumVars = myNumVars;
    }
    public List<Node> getMyCommands () {
        return myCommands;
    }
    public void setMyCommands (List<Node> myCommands) {
        this.myCommands = myCommands;
    }
    public String toString(){
        String string="[ ";
        for(String s: myVarNames){
            string=" "+string + s+" ";
        }
        string=string +" ]  ";
        for(Node n : myCommands){
            System.out.println(n.toString());
            string= " "+string+" "+n.toString();
        }
        return string;
    }
}
