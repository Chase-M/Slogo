// This entire file is part of my masterpiece
// KEVIN BUTTON

package components;

import java.util.HashMap;
import java.util.Map;

import mainApplication.Controller;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ImagesTab extends InfoTab {
   private Map<Integer, ImageView> myImages;

    public ImagesTab (String s, Controller c) {
        super(s, c);
        myImages = new HashMap<Integer, ImageView>();

    }

    @Override
    public void update (Object o) {
        myImages = (Map<Integer, ImageView>)o;
        getTextPane().getChildren().clear();
        setTextIndex(0);
        for (Integer i : myImages.keySet()) {
            getTextPane().add(new Label(i.toString()), 0, getTextIndex());
            getTextPane().add(myImages.get(i), 1, getTextIndex());
            setTextIndex(getTextIndex() + 1);

        }
    }
}
