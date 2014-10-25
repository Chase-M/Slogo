package mainApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import parser.Node;
import parser.Parser;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;
import workspace.Workspace;

public class Controller {
	
	private List<Workspace> myWorkspaces;
	private Parser myParser;
	private int myActive;
	private Workspace myActiveWS;
	private GUI myView;
	//TEMPORARY, REMOVE STAGE
	public Stage myStage;
	
	public Controller(Stage s){//TEMPORARY
		myStage = s;
		myWorkspaces = new ArrayList<>();

		myParser = new Parser();
	}
	
	public void parseAndEvaluate(String s) throws Exception{
		List<Node> list = myParser.parse(s);
		myActiveWS.evaluate(list);
	}
	
	public int createWorkspace(GUI gui){
		int i = 0;
		if(myWorkspaces != null)
			i = myWorkspaces.size();
		myActiveWS=new Workspace(i);
		myActiveWS.addObserver(gui);
		myActiveWS.createTurtle(0);

		myWorkspaces.add(myActiveWS);
		
		return myWorkspaces.size()-1;
	}
	
	public void setActive(int id){
		myActive = id;
		myActiveWS = myWorkspaces.get(myActive);
	}
	
	public Map<String,Double> getVariables(){
		return myActiveWS.getVariables();
	}
	
	public Map<Integer, Color> getColors(){
		return myActiveWS.getColors();
	}
	public void clear(){
		myActiveWS.clear();
	}
	

	
	public void saveMem(File f){
	    try {
       
            myActiveWS.writeMem(f);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	
}