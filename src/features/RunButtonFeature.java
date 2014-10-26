package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.InfoPane;
import components.InfoTab;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import actor.Turtle;
import parser.Node;
import parser.Parser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class RunButtonFeature extends Button implements Feature{
	private Controller myController;
	private LeftPane myLeftPane;
	private RightPane myRightPane;
	private CenterPane myCenterPane;
	private Button myButton;
	public Map<Integer, ImageView> myImageMap;
	
	/**
	 * Creates the run button that runs commands and also holds methods for interaction between command history and command area
	 * @param componentMap
	 * @param control
	 */
	
	public RunButtonFeature(Map<String, Pane> componentMap, Controller control){
	super("Run");
	myController = control;
	myImageMap = makeImageMap();
	
	   this.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	BottomPane bottomPane = (BottomPane)componentMap.get("class components.BottomPane");
		    	myLeftPane = (LeftPane)componentMap.get("class components.LeftPane");
		    	myRightPane = (RightPane)componentMap.get("class components.RightPane");
		    	myCenterPane = (CenterPane)componentMap.get("class components.CenterPane");
		    	
		    	if(!bottomPane.myCommand.getText().isEmpty()){
		    		try{
				myController.parseAndEvaluate(bottomPane.myCommand.getText());	
				myButton = new Button(bottomPane.myCommand.getText());
		        bottomPane.myCommand.clear();
	
	                    }
	                    
		    	
		    	catch(Exception n){
		    		bottomPane.updateErrors(n);
		    		n.printStackTrace();
		    		
		    	}
		    }
		    	updatePanes();
		    }
		    
		    
		});	   
	
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void updatePanes(){
		//Map<Integer, ImageView> imageMap = makeImageMap();
		myCenterPane.myTurtleManager.updateImageMap(myImageMap);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		 paramMap.put("class components.HistoryTab", myButton);//TODO Remove this, shouldn't update History
        paramMap.put("class components.VarsTab", myController.getVariables());
        paramMap.put("class components.TurtlesTab", myController.getVariables());
        paramMap.put("class components.ColorsTab", myController.getColors());        
        paramMap.put("class components.SavedTab", myController.getCommands());
        paramMap.put("class components.ImagesTab", myImageMap);
        List<InfoTab> list = myLeftPane.myTabs;
		for(InfoTab t:list){
			//t.clear();
			//System.out.println(paramMap.get(t.getClass().toString()));
			t.update(paramMap.get(t.getClass().toString()));
			
		}
		List<InfoTab> list2 = myRightPane.myTabs;
		for(InfoTab t:list2){
			//t.clear();
			//System.out.println(paramMap.get(t.getClass().toString()));
			t.update(paramMap.get(t.getClass().toString()));
			
		}
		
	}
	private Map<Integer, ImageView> makeImageMap(){
		Map<Integer, ImageView> map = new HashMap<Integer, ImageView>();
		String[] images = new String[]{"features/turtle.png", "features/rcd.jpg"}; 
		for(int i = 0; i< images.length; i++){
			Image image = new Image(images[i]);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(50);
			imageView.setFitWidth(26);
			map.put(i, imageView);
		}
		return map;
	}

}
