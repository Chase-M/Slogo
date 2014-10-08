package buttonInput;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import mainApplication.GUI;
import features.Feature;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;



public class Menubar extends MenuBar implements Feature{
	public Menu myMenu;

public Menubar(){
	super();
	MenuItem test = new MenuItem("test");
	MenuItem test2 = new MenuItem("test2");
	Menu subGuy = new Menu("check out these subs");
	MenuItem sub1 = new MenuItem("sub1");
	MenuItem sub2 = new MenuItem("sub2");
	MenuItem sub3 = new MenuItem("sub3");
	subGuy.getItems().addAll(sub1, sub2, sub3);
	List<MenuItem> list = new ArrayList<MenuItem>();
	list.add(test);
	list.add(test2);
	Menu file = new Menu("test3");
	for(MenuItem i:list){
//		setActions(i);
		file.getItems().add(i);

	}
	file.getItems().add(subGuy);
	myMenu=file;	
	this.getMenus().add(myMenu);

	
	//this.getChildren().add(myMenu);
}

//private void setActions(MenuItem i) {
//	i.setOnAction(new EventHandler<ActionEvent>(){
//		@Override
//		public void handle(ActionEvent event) {
//		}
//	});
//}

@Override
public void update() {
	// TODO Auto-generated method stub
	
}

}
