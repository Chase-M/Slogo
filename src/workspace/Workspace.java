package workspace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import parser.CommandObject;
import parser.Node;
import properties.StageProperties;
import properties.TurtleProperties;
import actor.Turtle;


public class Workspace extends Observable implements Observer {
    private static final String COLOR_PATH = "resources.constants/Color";
    private static final int DEFAULT_STAGE_COLOR = 0;
    private static final boolean NOT_CLEAR = false;
    private int myID;
    private Map<Integer, Turtle> myTurtles;
    private StageProperties myStageProperties;
    private Map<String, Double> myVariables;
    private Map<String, CommandObject> myCommands;
    private Map<Integer, Color> myColors;

    public Workspace (int id) {
        myTurtles = new HashMap<>();
        myID = id;
        myVariables = new HashMap<String, Double>();
        myCommands = new HashMap<String, CommandObject>();
        myColors = new HashMap<>();
        initializeColors();
        myStageProperties = new StageProperties(NOT_CLEAR, DEFAULT_STAGE_COLOR);
    }

    private void initializeColors () {
        ResourceBundle bundle = ResourceBundle.getBundle(COLOR_PATH);
        for (String index : bundle.keySet()) {
            myColors.put(Integer.parseInt(index), Color.valueOf(bundle.getString(index)));
        }
    }

    public Map<Integer, Color> getColors () {
        return myColors;
    }

    public void writeMem (File f) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(f, "UTF-8");
        for (String s : myVariables.keySet()) {
            writer.println("make " + s + " " + myVariables.get(s));
        }

        for (String s : myCommands.keySet()) {
            writer.println("to " + s);
            writer.println(myCommands.get(s));
        }
        writer.close();

    }

    // TODO this won't work because it will reassign variables incorrectly
    public void evaluate (List<Node> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).evaluate(this);

        }
    }

    public Map<String, Double> getVariables () {
        return myVariables;
    }

    public Map<String, CommandObject> getCommands () {
        return myCommands;
    }

    public void clear () {
        // TODO give GUI appropriate notification
        myTurtles.clear();
        myStageProperties.setClear(true);
        setChangedandNotify(myStageProperties);
        myStageProperties.setClear(false);
        createTurtle(0);
    }

    public void changeBackground (int i) {
        myStageProperties.setIndex(i);
        setChangedandNotify(myStageProperties);
    }
    
    public List<Turtle> getActiveTurtles () {
        List<Turtle> list = new ArrayList<Turtle>();
        for (Integer i : myTurtles.keySet()) {
            if (myTurtles.get(i).isActive()) {
                list.add(myTurtles.get(i));
            }
        }
        return list;
    }

    public Map<Integer, Turtle> getTurtles () {
        return myTurtles;
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        setChangedandNotify(arg1);
    }

    private void setChangedandNotify (Object arg1) {
        setChanged();
        notifyObservers(arg1);

    }

    public void createTurtle (int id) {
        Turtle turtle = new Turtle(id);
        myTurtles.put(id, turtle);
        turtle.addObserver(this);
        myTurtles.get(id).setChangedandNotify(new TurtleProperties(turtle));
    }
}
