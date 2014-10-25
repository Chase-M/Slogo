package parser;

import java.lang.reflect.InvocationTargetException;
import command.Command;
import exceptions.ParseException;

public class basicCommandCreator extends commandFactory{
    private static final String COMMAND_PATH="command.";
    @Override
    public Command createCommand (String name, String command) {
        // TODO Auto-generated method stub
        String className=COMMAND_PATH+name;
        Class<?> classType;
     try {
         classType = Class.forName(className);

        Command c = (Command)classType.getConstructor(String.class).newInstance(command);
        return c;
     }
     catch (Exception e1) {
         // TODO Auto-generated catch block
         throw new ParseException(command);
     }

    }
    }
    

