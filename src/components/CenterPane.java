package components;

import java.util.Map;

import properties.PenProperties;
import properties.TurtleProperties;
import features.DisplayTurtle;
import features.Feature;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;


public class CenterPane extends Pane implements Feature {

    public TurtleManager myTurtleManager;
    public GridPane referenceGrid;
    public Map<Integer, Color> colorsMap;
    public boolean animate;

    public CenterPane () {
        super();
        myTurtleManager = new TurtleManager(this);
        this.setStyle("-fx-background-color: white");
        referenceGrid = createReferenceGrid();
        animate = false;
        this.getChildren().add(referenceGrid);
        for (DisplayTurtle t : myTurtleManager.myTurtleMap.values()) {
            this.getChildren().add(t.myImage);
        }

    }

    @Override
    public void update () {

    }

    /**
     * updates the turtle position using specified turlte ID
     * @param pos: contains information on coordinates and angle
     */
    public void updateTurtlePosition (TurtleProperties pos) {
        myTurtleManager.update(pos);
        for (DisplayTurtle t : myTurtleManager.myTurtleMap.values()) {
            if (!this.getChildren().contains(t.myImage)) {
                if (t.isTurtleShowing) {
                    this.getChildren().add(t.myImage);
                }
            }
        }
    }
    /**
     * updates pen information
     * @param props: contains pen property information
     */
    public void updatePenProperties (PenProperties props) {
        myTurtleManager.updatePenProperties(props);
    }
    /**
     * clears the screen and resets to one turtle
     * @param clear: states whether or not screen is to be cleared
     */
    public void clearScreen (boolean clear) {
        myTurtleManager.clearScreen(clear);
    }

    /**
     * updates the pen style on all turtles in workspace
     * @param type: integer that corresponds to a specific line style
     */
    public void updatePenType (int type) {
        for (DisplayTurtle t : myTurtleManager.myTurtleMap.values()) {
            t.updatePenType(type);
        }
    }

    /**
     * updates the animation on/off on all turtles in workspace
     * @param bool: states whether or not animation should be turned on
     */
    public void updateAnimate (boolean bool) {
        animate = bool;

        for (DisplayTurtle t : myTurtleManager.myTurtleMap.values()) {
            t.updateAnimate(bool);
        }

    }
    /**
     * creates and adds reference grid to center pane
     * @return: gridpane that acts as reference grid
     */
    private GridPane createReferenceGrid () {

        GridPane refGrid = new GridPane();
        refGrid.setPrefSize(600, 400);
        refGrid.getColumnConstraints().add(new ColumnConstraints(38));
        refGrid.getRowConstraints().add(new RowConstraints(25));
        for (int i = 0; i < 12; i++) {
            refGrid.getColumnConstraints().add(new ColumnConstraints(50));
        }
        for (int i = 0; i < 10; i++) {
            refGrid.getRowConstraints().add(new RowConstraints(50));
        }

        return refGrid;

    }

    public void initiateColorsMap (Map<Integer, Color> map) {
        colorsMap = map;
    }

    public void updateAnimationSpeed (double speed) {
        for (DisplayTurtle t : myTurtleManager.myTurtleMap.values()) {
            t.updateSpeed(speed);

        }
    }

    public void updateBackgroundColor (int index) {
        Color newColor = (colorsMap.get(index));
        String colorString = newColor.toString().substring(2);
        this.setStyle("-fx-background-color: #" + colorString);

    }

}
