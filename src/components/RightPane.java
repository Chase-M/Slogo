package components;

import java.util.ArrayList;
import java.util.List;

import mainApplication.Controller;
import features.Feature;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.misc.Queue;


public class RightPane extends InfoPane implements Feature {

	public RightPane(Controller c) {
		super(c, new String[]{"ColorsTab", "ImagesTab"});
	}

}
