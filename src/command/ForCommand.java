package command;

import java.util.List;
import parser.Node;
import actor.Turtle;

public class ForCommand extends Command{
    
    public ForCommand(String s){
        super(s);
        myNumLists=2;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public double execute (List<Node> inputs, Turtle turtle) {
        // TODO Auto-generated method stub
        for(int i=(int) inputs.get(1).evaluate(turtle); i<inputs.get(2).evaluate(turtle); i=(int) (i+inputs.get(3).evaluate(turtle))){
           for(int j=4; j<inputs.size(); j++){ 
               inputs.get(j).evaluate(turtle);
           }
        }
        return 0;
    }

}
