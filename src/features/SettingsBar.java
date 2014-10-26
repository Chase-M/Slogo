package features;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import components.LeftPane;
import components.RightPane;
import parser.Node;
import parser.Parser;
import actor.Turtle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class SettingsBar extends ToolBar implements Feature{
	
	private int mySceneHeight;
	private static int mySceneWidth;
	private RightPane myRightPane;
	private LeftPane myLeftPane;
	private ResourceBundle myNumberResources;
	private Turtle myTurtle;
	private ComboBox<String> languageCB;
	private ComboBox<String> colourCB;
	private ColorPicker displayColourPicker;
	
	
public SettingsBar(){
	
	super();
//	setPrefWidth(mySceneWidth);
//	setSpacing(10);

//	setStyle("-fx-background-color: lightgray");
	
	//Button startButton = new Button("Start");
	//startButton.setPrefSize(100, 20);
	//startButton.setOnAction(new EventHandler<ActionEvent>(){
/*		@Override
		public void handle(ActionEvent event) {
			System.out.println("start button clicked");
			System.out.println(languageCB.getValue());
			System.out.println(displayColourPicker.getValue());
		}
		
	});
	
*/	
	Label colourLabel = new Label("Pen Colour:");
	Label languageLabel = new Label("Language Pack:");
	
	//displayColourPicker = new ColorPicker();
	
	colourCB = new ComboBox<String>();
	colourCB.getItems().addAll("White", "Yellow", "Green");
	
	
	languageCB = new ComboBox<String>();
	languageCB.getItems().addAll("English", "Spanish", "Chinese");
	languageCB.setOnAction((event) -> {
	    System.out.println(languageCB.getSelectionModel().getSelectedItem());
	   // System.out.println("ComboBox Action (selected: " + selectedPerson.toString() + ")");
	});
//	setMargin(languageCB, new Insets(6));
//	setMargin(colourCB, new Insets(6));
//	setMargin(colourLabel, new Insets(6));
//	setMargin(languageLabel, new Insets(6));
//	setMargin(startButton, new Insets(6));

	Label settingsBarLabel = new Label("Settings Bar:");


	this.getItems().addAll(colourLabel, colourCB, languageLabel, languageCB);

	//this.setPrefHeight(34);
}
	
public void updateColorPicker(ColorPicker cp){
	this.getItems().add(cp);
}

public void addSlider(Slider slider){
	
	Label penWidth = new Label("Pen Width:     ");
	Label zero = new Label("0");
	Label ten = new Label("10");
	this.getItems().addAll(penWidth, zero, slider, ten);

	
}

@Override
public void update() {
	// TODO Auto-generated method stub
	
}
	

}
