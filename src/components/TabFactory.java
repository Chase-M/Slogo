package components;

import java.lang.reflect.InvocationTargetException;

import mainApplication.Controller;


public class TabFactory {
		public static final String PATH_NAME = "components.";
		
	public InfoTab makeTab(String tabHeader, Controller cont){
		String className = PATH_NAME+tabHeader; 
		Class<?> c = null;
		try {
		c = Class.forName(className);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		InfoTab tab = null;
	 try {
		tab = (InfoTab) c.getConstructor(String.class, Controller.class).newInstance(tabHeader, cont);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return tab;	
}
}
