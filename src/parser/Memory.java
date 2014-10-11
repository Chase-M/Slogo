package parser;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    static Map<String, Node> myMem=new HashMap<String, Node>();
    public Memory(){
 
        
    }
    
    public void add(String name, Node node){
        myMem.put(name, node);
    }
    
    public boolean checkMem(String s){
        return myMem.containsKey(s);
    }
    
    public Node getNode(String s){
        return myMem.get(s);
    }
}

