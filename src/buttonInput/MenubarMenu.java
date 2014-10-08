package buttonInput;

import features.Feature;
import javafx.scene.control.MenuButton;



public class ToolbarButton{
	
private final GUI myGUI;
private final MenuBar myMenuBar;
/**
 * Generates the menu bar with the menu icons and associated dropdown menus, to be added
 * to the top left hand corner of the stage. This constructor is called from the "initiate"
 * method in the main GUI class.
 * 
 * @param gui : GUI for running the program.
 * @param language : Resource Bundle for the language the program is running in.
 * @param windowSizeX : Width of the stage.
 */
protected GUIMenuBar(GUI gui, ResourceBundle language, double windowSizeX){
	myGUI = gui;
	MenuItem openXML = new MenuItem(language.getString("MenuItemOpen"));
	MenuItem close = new MenuItem(language.getString("MenuItemClose"));
	Menu file = new Menu(language.getString("MenuBarFile"));
	setActions(openXML, close);
	file.getItems().addAll(openXML, close);
	myMenuBar = new MenuBar();
	myMenuBar.setMinWidth(windowSizeX);
	myMenuBar.getMenus().add(file);
}

/**
 * Getter method for the menu bar options displayed at the top of the GUI.
 * 
 * @return : Menu Bar with "File" and "Open XML..." options.
 */
protected MenuBar getMenubar(){
	return myMenuBar;
}

/**
 * Sets the actions available in the main menu dropdown. This method is called from
 * the "populateMenu" method.
 * 
 * @param openXML : Action to open a new XML file.
 * @param close : Action to close the stage and end the program.
 */
private void setActions(MenuItem openXML, MenuItem close) {
	openXML.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			if(myGUI.myAnimation.getStatus() == Status.RUNNING){
				myGUI.myWarning.show(myGUI.myStage);
				return;
			}
			FileChooser fileChoice = new FileChooser();
			fileChoice.getExtensionFilters().add(new ExtensionFilter("XML Files", "*.xml"));
			File selectedFile = fileChoice.showOpenDialog(myGUI.myStage);
			if(selectedFile != null){
				myGUI.mySelectedFile = selectedFile;
				myGUI.instantiateGrid();
			}
		}
	});
	close.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			myGUI.myStage.close();
		}
	});
}
}