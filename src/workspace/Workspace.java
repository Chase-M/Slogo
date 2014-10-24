package workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final Position DEFAULT_POSITION = new Position(0, 0, Math.PI / 2);
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
    public void evaluate (List<Node> list) {
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
        // TODO Auto-generated method stub

    }

    public void save (String s) {
        // TODO Auto-generated method stub

    }

    public Map<Integer,Turtle> getTurtles () {
        // TODO Auto-generated method stub
        return myTurtles;
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
    	System.out.println("hey2");
        setChanged();
        notifyObservers(arg1);
    }
    
    public void createTurtle(){
        Turtle turtle = new Turtle(DEFAULT_POSITION, new Pen(), 0);
        myTurtles.put(0, turtle);
        turtle.addObserver(this);
        myTurtles.get(0).setChangedandNotify(new TurtleProperties(turtle));
    }
}
