package components;

import features.Feature;
import features.SettingsBar;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;

public class TopPane extends FlowPane implements Feature {

    public SettingsBar mySettingsBar;
    private SettingsBar myPenBar;

    public TopPane () {
        super(Orientation.VERTICAL);
        mySettingsBar = new SettingsBar();
        this.getChildren().addAll(mySettingsBar);
        this.setPrefHeight(36);
        mySettingsBar.setPrefWidth(1000);
    }

    @Override
    public void update () {
        // TODO Auto-generated method stub

    }

    public void addItems (Node... n) {
        mySettingsBar.getItems().addAll(n);
    }

    public void addSlider (Slider slider) {
        mySettingsBar.getItems().add(slider);
    }

}
