package features;

import java.util.List;
import java.util.Map;
import mainApplication.Controller;
import components.BottomPane;
import components.CenterPane;
import components.LeftPane;
import components.RightPane;
import components.TopPane;
import actor.Turtle;
import parser.Node;
import parser.Parser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class RunButtonFeature extends Button implements Feature {
    public RunButtonFeature (Map<String, Pane> componentMap, Controller myController) {
        super("Run");
        // setDisabled(true);
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                BottomPane bottomPane =
                        (BottomPane) componentMap.get("class components.BottomPane");
                RightPane rightPane = (RightPane) componentMap.get("class components.RightPane");
                LeftPane leftPane = (LeftPane) componentMap.get("class components.LeftPane");

                // TODO move this + don't only have one turtle + it shouldn't even be here
                // List<Node> list = parser.parse(bottomPane.myCommand.getText());
                // for(Node n: list){
                // System.out.println(n.evaluate(turtle));
                // }
                if (!bottomPane.myCommand.getText().isEmpty()) {
                    try {
                        myController.parseAndEvaluate(bottomPane.myCommand.getText());

                    final Button button = new Button(bottomPane.myCommand.getText());
                    final Label label = new Label(bottomPane.myCommand.getText());
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle (ActionEvent e) {
                            bottomPane.myCommand.setText(button.getText());
                        }
                    });
                    rightPane.update(button);
                    leftPane.tempTabThing.update(label);
                    leftPane.tempTabThing2.update(button);
                    bottomPane.myCommand.clear();
                    }
                    catch (Exception e1) {
                        // TODO Auto-generated catch block
                        bottomPane.myCommand.setText(e1.toString());
                    }
                    
                }
                // bottomPane.update();
            }
        });

    }

    @Override
    public void update () {
        // TODO Auto-generated method stub

    }
}
