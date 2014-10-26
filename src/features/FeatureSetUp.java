package features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import parser.Parser;
import actor.Turtle;
import javafx.scene.layout.Pane;
import command.Command;
import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;


public class FeatureSetUp{
	public Map<String, Feature> myFeatureMap;
	public Map<String, Pane> myComponentMap;

	public FeatureSetUp(List<Pane> myComponents, Controller myController){
		
		myComponentMap = createComponentMap(myComponents);
		myFeatureMap = new HashMap<String, Feature>();
		
		RunButtonFeature run = new RunButtonFeature(myComponentMap, myController);
		myFeatureMap.put("RUN", run);
		
		ColorPickerFeature colorPick = new ColorPickerFeature(myComponentMap);
		myFeatureMap.put("COLORPICK", colorPick);
		
	//	OpenButtonFeature open = new OpenButtonFeature(myController);
	//	myFeatureMap.put("OPEN", open);
		
	//	SaveButtonFeature save = new SaveButtonFeature(myController);
	//	myFeatureMap.put("SAVE", save);
		
		ToggleGridButtonFeature gridButton = new ToggleGridButtonFeature(myComponentMap);
		myFeatureMap.put("GRID", gridButton);
		
		PenWidthSliderFeature penSlider = new PenWidthSliderFeature(myComponentMap, myController);
		myFeatureMap.put("PENSLIDER", penSlider);
		
		PenTypeComboBoxFeature penType = new PenTypeComboBoxFeature(myComponentMap, myController);
		myFeatureMap.put("PENTYPE", penType);
		

		AnimateButtonFeature animateButton = new AnimateButtonFeature(myComponentMap);
		myFeatureMap.put("ANIMATE", animateButton);
		
		AnimationSpeedSliderFeature animationSlider = new AnimationSpeedSliderFeature(myComponentMap);
		myFeatureMap.put("ANIMATIONSLIDER", animationSlider);

		LanguageComboFeature lang = new LanguageComboFeature(myController, new String[]{"English", "Chinese"});
		myFeatureMap.put("LANG", lang);
		

		
	}
	
	public Map<String,Pane> createComponentMap(List<Pane> myComponents){
		Map<String, Pane> componentMap = new HashMap<String, Pane>();
		  
		for(Pane p:myComponents){
			//String name = p.getClass().toString();
			componentMap.put(p.getClass().toString(), p);	//Not a great solution
			System.out.println(p.getClass().toString());
			//TODO fix this ish
			//Class<?> classType = Class.forName
		}
		     //   String className=COMMAND_PATH+name;
		       // Class<?> classType;
		  //   try {
		       //  classType = Class.forName(className);

		     //   Command c = (Command)classType.getConstructor(String.class).newInstance(command);
		       // return c;
		  //   }
		//     catch (ClassNotFoundException e1) {
		         // TODO Auto-generated catch block
		 //        e1.printStackTrace();
		//     }
		
	/*	
		for(Pane p: myComponents){
			  
			   if(p instanceof BottomPane){
				   componentMap.put("BOTTOM", p);
			   }
			   else if(p instanceof CenterPane){
				   componentMap.put("CENTER", p);	
				   }
			   else if(p instanceof LeftPane){
				   componentMap.put("LEFT", p);
				   }
			   else if(p instanceof RightPane){
				   componentMap.put("RIGHT", p);
				   }
			   else if(p instanceof TopPane){
				   componentMap.put("TOP", p);
				   }
		   }
		   */
		return componentMap;
	}
}
