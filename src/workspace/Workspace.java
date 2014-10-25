package workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.paint.Color;
import actor.Pen;
import actor.Turtle;
import parser.CommandObject;
import parser.Node;
import properties.Position;
import properties.StageProperties;
import properties.TurtleProperties;


public class Workspace extends Observable implements Observer {
	private int myID;
	private Map<Integer, Turtle> myTurtles;
	private String myLanguage;
	private StageProperties myStageProperties;
	private Map<String, Double> myVariables;
	private Map<String, CommandObject> myCommands;
	private List<Color> myColors;
	public Workspace (int id) {
		myTurtles = new HashMap<>();
		myID = id;
		myVariables = new HashMap<String, Double>();
		myCommands = new HashMap<String, CommandObject>();
		myColors=new ArrayList<Color>();
		myColors.add(Color.BLACK);

	}

	public Workspace (File f) {
		// TODO Auto-generated constructor stub
	}

	// TODO this won't work because it will reassign variables incorrectly
	public void evaluate (List<Node> list) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).evaluate(this);

		}
	}

	public Map<String, Double> getVariables () {
		// TODO Auto-generated method stub
		return myVariables;
	}

	public Map<String, CommandObject> getCommands () {
		return myCommands;
	}

	public void clear () {
		// TODO give GUI appropriate notification
		myTurtles.clear();
		createTurtle(0);
	}

	public void save (String s) {
		// TODO Auto-generated method stub

	}

	public List<Turtle> getActiveTurtles () {
		// TODO Auto-generated method stub
		List<Turtle> list=new ArrayList<Turtle>();
		for(Integer i: myTurtles.keySet()){
			if(myTurtles.get(i).isActive())
				list.add(myTurtles.get(i));
		}
		return list;
	}
	public Map<Integer, Turtle> getTurtles(){
		return myTurtles;
	}

	@Override
	public void update (Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers(arg1);
	}

	public void createTurtle(int id){
		Turtle turtle = new Turtle(id);
		myTurtles.put(id, turtle);
		turtle.addObserver(this);
		myTurtles.get(id).setChangedandNotify(new TurtleProperties(turtle));
	}
}
