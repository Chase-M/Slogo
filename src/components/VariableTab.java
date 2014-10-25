package components;

import java.util.Map;

import javafx.scene.control.Label;

public class VariableTab extends InfoTab{

	public VariableTab(String s) {
		super(s);
	}
	
	public void updateVars(Map<String, Double> vars){
	myTextIndex = 0;
	for(String s:vars.keySet()){
		myTextPane.add(new Label(s), 0, myTextIndex);
		myTextPane.add(new Label(vars.get(s).toString()), 1, myTextIndex);
		myTextIndex++;
	}
}


}
