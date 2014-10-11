package command;

import java.util.List;
import parser.Node;
import actor.Actor;

public class StringCommand extends Command{
    String myString;
    public StringCommand(String s){
            super();
            myString = s;
            myNumInputs = 0;
    }
    
    @Override
    public double execute(List<Node> inputs, List<Actor> actors) {
            return 0;
    }

    public String getString(){
        return myString;
    }
}
