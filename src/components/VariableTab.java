package components;

import java.util.Map;

import javafx.scene.control.Label;

public class VariableTab extends InfoTab{

	public VariableTab(String s) {
		super(s);
	}
	@Override
	public void update(Object o){
//		try{
		Map<String, Double> vars = (Map<String,Double>) o;
		myTextPane.getChildren().clear();
	myTextIndex = 0;
	if(!vars.equals(null)){
	for(String s:vars.keySet()){
		myTextPane.add(new Label(s), 0, myTextIndex);
		myTextPane.add(new Label(vars.get(s).toString()), 1, myTextIndex);
		myTextIndex++;
	}
	}
//		}
//	catch(NullPointerException e){
//		System.out.println("null n stuff");
//	}
	
}
//		}


}
