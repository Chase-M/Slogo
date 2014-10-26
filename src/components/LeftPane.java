package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mainApplication.Controller;
import features.Feature;
import features.TextDisplayFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sun.misc.Queue;


public class LeftPane extends InfoPane implements Feature {

	public LeftPane(Controller c) {
		super(c, new String[]{"VarsTab", "HistoryTab"});
	}

}
