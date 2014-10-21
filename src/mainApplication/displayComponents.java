package mainApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import parser.Node;
import parser.Parser;
//import textOutput.ConsoleHistory;
//import textOutput.VariableDisplay;
import actor.Turtle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class displayComponents{
	
	private int mySceneHeight;
	private static int mySceneWidth;
//	private ConsoleHistory myConsoleHistory;
//	private VariableDisplay myVariableDisplay;
	private ResourceBundle myNumberResources;
	private static ComboBox languageCB;
	private static ComboBox colourCB;
	
	
	private void initiate(){
		myNumberResources = ResourceBundle.getBundle("resources/constants/numbers");
		mySceneHeight = Integer.parseInt(myNumberResources.getString("Scene_height"));
		mySceneWidth = Integer.parseInt(myNumberResources.getString("Scene_width"));
	}
	
	
	
	
	
public static HBox topHBox(){
		
		HBox topHB = new HBox();
		topHB.setPrefWidth(mySceneWidth);
		topHB.setSpacing(10);
		topHB.setStyle("-fx-background-color: yellow;");
		
		Button startButton = new Button("Start");
		startButton.setPrefSize(100, 20);
		startButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("start button clicked");
				System.out.println(languageCB.getValue());
				System.out.println(colourCB.getValue());
			}
			
		});
		
		
		Label colourLabel = new Label("Display Colour:");
		Label languageLabel = new Label("Language Pack:");
		
		colourCB = new ComboBox();
		colourCB.getItems().addAll("White", "Yellow", "Green");
		
		languageCB = new ComboBox();
		languageCB.getItems().addAll("English", "Spanish", "Chinese");
		
	
		topHB.getChildren().addAll(colourLabel, colourCB, languageLabel, languageCB, startButton);
		topHB.setPrefHeight(34);
		return topHB;	
		
	}
	

}
