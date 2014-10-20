package command;

import java.util.List;
import parser.VarMemory;
import parser.Node;
import actor.Turtle;

public class MakeCommand extends Command{
    

    public MakeCommand(String s){
        super(s);
    }
    @Override
    public double execute (List<Node> inputs, Turtle turtle) {
        // TODO Auto-generated method stub
        VarMemory mem=new VarMemory();
        String name=inputs.get(0).getCommand().toString();
        mem.add(name, inputs.get(1));
        return 0;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 2;
    }

}
