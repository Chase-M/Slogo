package command;

import java.util.List;
import parser.Node;
import actor.Turtle;

public class StringCommand extends Command{
    String myString;
    public StringCommand(String s){
            super();
            myString = s;

    }
    
    public String getString(){
        return myString;
    }

    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double execute (List<Node> inputs, Turtle turtle) {
        // TODO Auto-generated method stub
        return 0;
    }
}
