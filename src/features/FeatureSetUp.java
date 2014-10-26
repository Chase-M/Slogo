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

	/**
	 * Adds the required features into a map 
	 * @param myComponents: Contains information on the Panes used
	 * @param myController: local instance of controller
	 */
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
	
	
	/**
	 * creates that map containing strings mapped to panes
	 * @param myComponents: initial Map that does not contain strings
	 * @return
	 */
	public Map<String,Pane> createComponentMap(List<Pane> myComponents){
		Map<String, Pane> componentMap = new HashMap<String, Pane>();
		  
		for(Pane p:myComponents){
			componentMap.put(p.getClass().toString(), p);

		}

		return componentMap;
	}
}
