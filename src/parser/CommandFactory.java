package parser;

import command.Command;


public abstract class CommandFactory {
    public abstract Command createCommand (String name, String command);

}
