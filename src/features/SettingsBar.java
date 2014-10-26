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

public class SettingsBar extends ToolBar {

    private int mySceneHeight;
    private static int mySceneWidth;
    private RightPane myRightPane;
    private LeftPane myLeftPane;
    private ResourceBundle myNumberResources;
    private Turtle myTurtle;
    private ComboBox<String> languageCB;
    private ComboBox<String> colourCB;
    private ColorPicker displayColourPicker;

    public SettingsBar () {
        super();
    }

    public void updateColorPicker (ColorPicker cp) {
        this.getItems().add(cp);
    }

    public void addPenSlider (Slider slider) {

        Label penWidth = new Label("Pen Width:     ");
        Label zero = new Label("0");
        Label ten = new Label("10");
        this.getItems().addAll(penWidth, zero, slider, ten);
    }

    public void addComboBox (ComboBox cb) {
        Label penTypeLabel = new Label("Pen Type: ");
        this.getItems().addAll(penTypeLabel, cb);
    }

    public void addAnimationSlider (Slider s) {
        Label animateLabel = new Label("Animation Speed:");
        this.getItems().addAll(animateLabel, s);
    }

    public void addButton (Button b) {
        this.getItems().addAll(b);

    }

}
