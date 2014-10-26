package parser;

import java.lang.reflect.InvocationTargetException;
import command.Command;
import exceptions.ParseException;


public class BasicCommandCreator extends CommandFactory {
    private static final String COMMAND_PATH = "command.";

    @Override
    public Command createCommand (String name, String command) {
        String className = COMMAND_PATH + name;
        Class<?> classType;
        Command c;
        try {
            classType = Class.forName(className);
            c = (Command)classType.getConstructor(String.class).newInstance(command);
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException
                | ClassNotFoundException e) {
            throw new ParseException(command);
        }
        return c;

    }
}
