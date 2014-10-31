// This entire file is part of my masterpiece
// KEVIN BUTTON

package components;

import java.util.ResourceBundle;

import mainApplication.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public abstract class InfoTab extends Tab {

    /**
     * Initializes the display area for console history as well as error display
     */
    private GridPane myTextPane;
    private ScrollPane myScrollPane;
    private VBox myDrawer;
    private int myTextIndex;
    private int myWidth;
    private Controller myController;
    private ResourceBundle myNumResources;

    public InfoTab (String s, Controller c) {
        super(s.substring(0, s.length() - 3));        
        myTextIndex = 0;
        myController = c;
        myNumResources = ResourceBundle.getBundle("resources/constants/numbers");
        myWidth = Integer.parseInt(myNumResources.getString("InfoTab_Width"));
        setClosable(false);
        createDrawer();
        createScrollAndTextPanes();
        myDrawer.getChildren().add(myScrollPane);
        VBox.setMargin(myScrollPane, new Insets(
                Integer.parseInt(myNumResources.getString("InfoTab_Insets"))));
        this.setContent(myDrawer);

    }
    
    private void createDrawer () {
        myDrawer = new VBox();
        myDrawer.setStyle("-fx-background-color: #336666");
        myDrawer.setPrefHeight(
                Integer.parseInt(myNumResources.getString("InfoTab_InnerHeight")));
        myDrawer.setPrefWidth(myWidth);
    }
    
    private void createScrollAndTextPanes () {
        myTextPane = new GridPane();
        myScrollPane = new ScrollPane();
        myScrollPane.setContent(myTextPane);
        myScrollPane.setPrefHeight(
                Integer.parseInt(myNumResources.getString("InfoTab_Height")));
        myScrollPane.setPrefWidth(myWidth);
    }

    public void clear () {
        myTextPane.getChildren().clear();
        myTextIndex = 0;
    }

    public void update (Object o) {
    }

    protected VBox getDrawer () {
        return myDrawer;
    }

    protected GridPane getTextPane () {
        return myTextPane;
    }

    protected int getTextIndex () {
        return myTextIndex;
    }

    protected void setTextIndex (int i) {
        myTextIndex = i;
    }

    protected Controller getController () {
        return myController;
    }
}
