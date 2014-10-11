package command;

import java.util.List;
import parser.VarMemory;
import parser.Node;
import actor.Turtle;

public class MakeCommand extends Command{
    
    public MakeCommand(){
        super();
    }
    public MakeCommand(String s){
        this();
    }
    @Override
    public double execute (List<Node> inputs, List<Turtle> actors) {
        // TODO Auto-generated method stub
        VarMemory mem=new VarMemory();
        String name=((StringCommand)inputs.get(0).getCommand()).getString();
        mem.add(name, inputs.get(1));
        return 0;
    }
    @Override
    protected int setNumInputs () {
        // TODO Auto-generated method stub
        return 2;
    }

}
