package parser;

import java.lang.reflect.InvocationTargetException;
import command.Command;

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
     catch (ClassNotFoundException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
     }
     catch (InstantiationException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     catch (IllegalAccessException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     catch (IllegalArgumentException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     catch (InvocationTargetException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     catch (NoSuchMethodException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     catch (SecurityException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }

                return null;
    }
    }
    

