package command;

import java.util.List;
import parser.VarMemory;
import parser.Node;
import actor.Actor;

public class MakeCommand extends Command{
    
    public MakeCommand(){
        super();
        myNumInputs=2;
    }
    public MakeCommand(String s){
        this();
    }
    @Override
    public double execute (List<Node> inputs, List<Actor> actors) {
        // TODO Auto-generated method stub
        VarMemory mem=new VarMemory();
        String name=((StringCommand)inputs.get(0).getCommand()).getString();
        mem.add(name, inputs.get(1));
        return 0;
    }

}
