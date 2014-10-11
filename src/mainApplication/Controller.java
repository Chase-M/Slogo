package mainApplication;

import java.util.List;

import parser.Node;
import javafx.scene.Scene;
import view.View;

public class Controller {
	
	private View myView;
	private Model myModel;
	
	public Controller(){
		myView = new View(this);
		myModel = new Model(this);
		
	}

	public Scene getScene() {		
		return myView.getScene();
	}
	public double parseAndEvaluate(String s){
		return evaluate(parse(s));
	}
	public List<Node> parse(String s){
		return myModel.parse(s);
	}
	public double evaluate(List<Node> commands){
		return myModel.evaluate(commands);
	}
}
