package command;

import java.util.List;
import parser.Node;
import actor.Turtle;

public class ListEndCommand extends Command{
    
    public ListEndCommand(String s){
        super(s);
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
