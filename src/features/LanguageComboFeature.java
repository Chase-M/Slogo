package features;

import mainApplication.Controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;

public class LanguageComboFeature extends ComboBox<String> implements Feature {
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
