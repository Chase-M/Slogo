// This entire file is part of my masterpiece
// KEVIN BUTTON

package components;

import mainApplication.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HistoryTab extends InfoTab {

    public HistoryTab (String s, Controller c) {
        super(s, c);
        Button clear = new Button("Clear");
        getDrawer().getChildren().add(clear);
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle (ActionEvent arg0) {
                getTextPane().getChildren().clear();
            }

        });
    }

    @Override
    public void update (Object o) {
        Button b = (Button)o;
        getTextPane().add(b, 0, getTextIndex());
        setTextIndex(getTextIndex() + 1);
    }
}
