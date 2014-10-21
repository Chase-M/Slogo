package command;

import java.util.List;
import parser.Node;
import actor.Turtle;

public class ListStartCommand extends Command {
    
    public ListStartCommand(String s){
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
