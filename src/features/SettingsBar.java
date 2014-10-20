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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class SettingsBar extends HBox implements Feature{
	
	private int mySceneHeight;
	private static int mySceneWidth;
	private RightPane myRightPane;
	private LeftPane myLeftPane;
	private ResourceBundle myNumberResources;
	private Turtle myTurtle;
	private static ComboBox<String> languageCB;
	private static ComboBox<String> colourCB;
	
	
public SettingsBar(){
	
	super();
	setPrefWidth(mySceneWidth);
	setSpacing(10);
	setStyle("-fx-background-color: lightgray");
	
	Button startButton = new Button("Start");
	startButton.setPrefSize(100, 20);
	startButton.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			System.out.println("start button clicked");
			System.out.println(languageCB.getValue());
			System.out.println(colourCB.getValue());
		}
		
	});
	
	
	Label colourLabel = new Label("Display Colour:");
	Label languageLabel = new Label("Language Pack:");
	
	colourCB = new ComboBox<String>();
	colourCB.getItems().addAll("White", "Yellow", "Green");
	
	languageCB = new ComboBox<String>();
	languageCB.getItems().addAll("English", "Spanish", "Chinese");
	setMargin(languageCB, new Insets(6));
	setMargin(colourCB, new Insets(6));
	setMargin(colourLabel, new Insets(6));
	setMargin(languageLabel, new Insets(6));
	setMargin(startButton, new Insets(6));

	this.getChildren().addAll(colourLabel, colourCB, languageLabel, languageCB, startButton);
	//this.setPrefHeight(34);
}
	
	


@Override
public void update() {
	// TODO Auto-generated method stub
	
}
	

}
