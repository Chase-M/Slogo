// This entire file is part of my masterpiece
// KEVIN BUTTON

package components;

import java.lang.reflect.InvocationTargetException;

import mainApplication.Controller;

public class TabFactory {
    public static final String PATH_NAME = "components.";

    public InfoTab makeTab (String tabHeader, Controller cont) throws ClassNotFoundException, 
    InstantiationException, InvocationTargetException, IllegalArgumentException,
    IllegalAccessException, NoSuchMethodException, SecurityException{
        String className = PATH_NAME + tabHeader;
        Class<?> c = null;
            c = Class.forName(className);
        InfoTab tab = null;
            tab = (InfoTab)c.getConstructor(String.class, Controller.class).newInstance(tabHeader,
                    cont);
        return tab;
    }
}
