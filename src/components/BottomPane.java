package components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class BottomPane extends HBox {
    public final TextArea myCommand;
    public final Label myErrors;

    public BottomPane () {
        setPrefWidth(1000);
        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        myCommand = new TextArea();
        myCommand.setPrefRowCount(3);
        ScrollPane scroller = new ScrollPane();
        scroller.setPrefHeight(100);
        scroller.setMaxWidth(300);
        scroller.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

        setStyle("-fx-background-color: #336699;");
        myErrors = new Label("ERRORS:\n\n");
        myErrors.setStyle("-fx-background-color: #ffffff;"
                + "-fx-border-width: 2;-fx-border-color: black;");
        myErrors.setPadding(new Insets(15, 12, 15, 12));
        myErrors.setPrefHeight(100);
        myErrors.setMinWidth(300);
        scroller.setContent(myErrors);
        this.getChildren().addAll(myCommand, myErrors);
    }
    /**
     * adds a button to the bottom pane
     * @param run: button to be added to bottom pane
     */
    public void updateButton (Button run) {
        this.getChildren().add(run);
    }

    /**
     * displays errors in the right text areas
     * @param e: errors that are to be displayed
     */
    public void updateErrors (Exception e) {
        myErrors.setText("ERRORS:\n" + e.toString());

    }
}
