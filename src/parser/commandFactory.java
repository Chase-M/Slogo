package parser;

import command.Command;

public abstract class commandFactory {
    public abstract Command createCommand(String command);
    
}
