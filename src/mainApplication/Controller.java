package mainApplication;

/**
 * @author Timesh Patel, Chase Malik
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.paint.Color;
import parser.CommandObject;
import parser.Node;
import parser.Parser;
import properties.LanguageProperties;
import workspace.Workspace;


public class Controller {

    private List<Workspace> myWorkspaces;
    private Parser myParser;
    private int myActive;
    private Workspace myActiveWS;

    /**
     * Controller that coordinates between front end and back end
     * keeps a list of workspaces and held by the GUI
     * also contains the only parser
     */
    public Controller () {
        myWorkspaces = new ArrayList<>();
        myParser = new Parser();
    }

    /**
     * takes a string and parses it into a graph of nodes which is
     * then evaluated on over the current workspace
     * 
     * @param s
     * @throws Exception
     */
    public void parseAndEvaluate (String s) throws Exception {
        List<Node> list = myParser.parse(s);
        myActiveWS.evaluate(list);
    }

    /**
     * creates a new workspace, sets the gui it belongs to and add its as a
     * observer and creates its furst turtle
     * 
     * @param gui
     * @return
     */
    public int createWorkspace (GUI gui) {
        myActiveWS = new Workspace();
        myActiveWS.addObserver(gui);
        myActiveWS.createTurtle(0);

        myWorkspaces.add(myActiveWS);

        return myWorkspaces.size() - 1;
    }

    /**
     * sets active workspace
     * 
     * @param id
     */
    public void setActive (int id) {
        myActive = id;
        myActiveWS = myWorkspaces.get(myActive);
    }

    public void removeWS (int id) {
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

    /**
     * saves Variables and Stored commands
     * 
     * @param f
     * @throws Exception
     */
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
        LanguageProperties.Language = "Cool";
    }

}
