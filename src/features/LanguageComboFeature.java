package features;

import mainApplication.Controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;

public class LanguageComboFeature extends ComboBox<String> implements Feature {
	/**
	 * creates combobox for language selection
	 * @param control: controller
	 * @param s: Strings to be added as options in combo box
	 */
	public LanguageComboFeature(Controller control, String ... s){
		super();
		getItems().addAll(s);
		this.setOnAction((event) -> {
				control.setLanguage(this.getSelectionModel().getSelectedItem());
		});
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
