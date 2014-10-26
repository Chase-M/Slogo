package components;

import java.lang.reflect.InvocationTargetException;

import mainApplication.Controller;


public class PaneFactory {
		//private static final PATH_NAME = "components.";
		public static final String PATH_NAME = "components.";
		
	public InfoPane makePane(Controller cont, String tabHeader){
		//Add properties file with map of header name to class name
		String className = PATH_NAME+tabHeader; //add resourcefile
		Class<?> c = null;
		try {
		c = Class.forName(className);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		InfoPane pane = null;
	 try {
		pane = (InfoPane) c.getConstructor(Controller.class).newInstance(cont);
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// () c.getConstructor(String.class, Integer.class).newInstance();
	return pane;	
}
}
