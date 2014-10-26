package components;

import java.lang.reflect.InvocationTargetException;

import mainApplication.Controller;


public class PaneFactory {
		public static final String PATH_NAME = "components.";
		
	public InfoPane makePane(Controller cont, String tabHeader){
		String className = PATH_NAME+tabHeader; 
		Class<?> c = null;
		try {
		c = Class.forName(className);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		InfoPane pane = null;
	 try {
		pane = (InfoPane) c.getConstructor(Controller.class).newInstance(cont);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return pane;	
}
}
