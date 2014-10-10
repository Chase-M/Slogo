package parser;

import command.Command;
import command.IntCommand;

public class intCommandCreator extends commandFactory{

    @Override
    public Command createCommand (String command) {
        // TODO Auto-generated method stub
        return new IntCommand(Integer.parseInt(command));
    }

}
