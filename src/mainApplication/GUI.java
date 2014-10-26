package mainApplication;

import actor.Turtle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import components.BottomPane;
import components.InfoPane;
import components.InfoTab;
import components.LeftPane;
import components.PaneFactory;
import components.RightPane;
import components.TopPane;
import components.CenterPane;
import features.DisplayTurtle;
import features.FeatureSetUp;
import features.LanguageComboFeature;
import features.RunButtonFeature;
import parser.Parser;
import properties.PenProperties;
import properties.Position;
import properties.StageProperties;
import properties.TurtleProperties;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GUI extends Pane implements Observer {

    /**
     * Activates the necessary components for GUI
     */

    private Turtle myTurtle;
    private CenterPane myCenterPane;
    private Parser myParser;
    protected BottomPane myBottomPane;
    private TopPane myTopPane;

    private InfoPane myLeftPane;
    private InfoPane myRightPane;
    public int myGUIid;

    private Map<Integer, Color> colorsMap;

    private Controller myController;
    private Scene myScene;

    public static List<DisplayTurtle> myObjects;

    public GUI (Controller controller, Scene s) {
        myController = controller;
        myScene = s;
    }

    void initiate () {
        loadPanes();
        myParser = new Parser();
        myGUIid = myController.createWorkspace(this);
        initiateKeyPress(myScene);

    }

    private void loadPanes () {
        BorderPane pane = new BorderPane();

        PaneFactory paneFac = new PaneFactory();
        myLeftPane = paneFac.makePane(myController, "LeftPane");
        myRightPane = paneFac.makePane(myController, "RightPane");
        myTopPane = new TopPane();
        myBottomPane = new BottomPane();
        myCenterPane = new CenterPane();

        ScrollPane myScroller = new ScrollPane();
        myScroller.setMaxHeight(400);
        myScroller.setMaxWidth(600);
        myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        myScroller.setContent(myCenterPane);
        pane.setLeft(myLeftPane);
        pane.setRight(myRightPane);

        List<Pane> components = new ArrayList<Pane>();
        components.add(myRightPane);
        components.add(myLeftPane);
        components.add(myTopPane);
        components.add(myBottomPane);
        components.add(myCenterPane);

        FeatureSetUp features = new FeatureSetUp(components, myController);
        RunButtonFeature run = (RunButtonFeature) features.myFeatureMap.get("RUN");
        ColorPicker CP = (ColorPicker) features.myFeatureMap.get("COLORPICK");
        Button grid = (Button) features.myFeatureMap.get("GRID");
        Slider penSlider = (Slider) features.myFeatureMap.get("PENSLIDER");
        ComboBox penType = (ComboBox) features.myFeatureMap.get("PENTYPE");
        Button animate = (Button) features.myFeatureMap.get("ANIMATE");
        Slider animationSlider = (Slider) features.myFeatureMap.get("ANIMATIONSLIDER");
        LanguageComboFeature lang = (LanguageComboFeature) features.myFeatureMap.get("LANG");
        myTopPane.addItems(grid, new Separator(), CP, new Separator(), lang);
        myBottomPane.updateButton(run);
        myBottomPane.updateButton(animate);
        myCenterPane.myTurtleManager.updateImageMap(run.myImageMap);

        myTopPane.mySettingsBar.addPenSlider(penSlider);
        myTopPane.mySettingsBar.addAnimationSlider(animationSlider);
        myTopPane.mySettingsBar.addComboBox(penType);

        pane.setBottom(myBottomPane);
        pane.setCenter(myScroller);
        pane.setTop(myTopPane);

        this.getChildren().add(pane);
    }

    @Override
    public void update (Observable obs, Object props) {
        if (props instanceof TurtleProperties) {
            try {
                myCenterPane.updateTurtlePosition((TurtleProperties) props);
            } catch (NullPointerException e) {
                myBottomPane.myErrors.setText("ERRORS:\nImage Index out of Palette Bounds");
            }
        }
        if (props instanceof PenProperties) {
            myCenterPane.initiateColorsMap(myController.getColors());
            myCenterPane.updatePenProperties((PenProperties) props);

        }
        if (props instanceof StageProperties) {

            myCenterPane.clearScreen(((StageProperties) props).isClear());
            myCenterPane.updateBackgroundColor(((StageProperties) props).getIndex());
        }


    }

    public void initiateKeyPress (Scene s) {
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                switch (event.getCode()) {
                case W:
                    try {
                        myController.parseAndEvaluate("setheading 90 fd 25");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case S:
                    try {
                        myController.parseAndEvaluate("setheading 270 fd 25");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case D:
                    try {
                        myController.parseAndEvaluate("setheading 0 fd 25");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case A:
                    try {
                        myController.parseAndEvaluate("setheading 180 fd 25");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }

            }
        });
    }

}
