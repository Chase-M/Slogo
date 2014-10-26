package mainApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import parser.CommandObject;
import parser.Node;
import parser.Parser;
import workspace.Workspace;


public class Controller {


    private List<Workspace> myWorkspaces;
    private Parser myParser;
    private int myActive;
    private Workspace myActiveWS;
    // TEMPORARY, REMOVE STAGE


    public Controller () {// TEMPORARY   
        myWorkspaces = new ArrayList<>();
        myParser = new Parser();
    }

    public void parseAndEvaluate (String s) throws Exception {
        List<Node> list = myParser.parse(s);
        myActiveWS.evaluate(list);
    }

    public int createWorkspace (GUI gui) {
        int i = 0;
        if (myWorkspaces != null) {
            i = myWorkspaces.size();
        }
        myActiveWS = new Workspace(i);
        myActiveWS.addObserver(gui);
        myActiveWS.createTurtle(0);

        myWorkspaces.add(myActiveWS);

        return myWorkspaces.size() - 1;
    }

    public void setActive (int id) {
        myActive = id;
        myActiveWS = myWorkspaces.get(myActive);
    }
    public void removeWS (int id){
        myWorkspaces.remove(id);
    }

    public Map<String, Double> getVariables () {
        return myActiveWS.getVariables();
    }

    public Map<String, CommandObject> getCommands () {
        return myActiveWS.getCommands();
    }

    public Map<Integer, Color> getColors () {
        return myActiveWS.getColors();
    }

    public void clear () {
        myActiveWS.clear();
    }

    public void saveMem (File f) throws Exception {

        try {
            myActiveWS.writeMem(f);
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw e;
        }
    }

    public void setLanguage (String language) {
        myParser.changeLanguage(language);
    }

}
