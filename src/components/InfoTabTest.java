// This entire file is part of my masterpiece
// KEVIN BUTTON

package components;

import static org.junit.Assert.assertEquals;
import javafx.scene.control.Button;
import mainApplication.Controller;

import org.junit.Test;

public class InfoTabTest {
    @Test
    public void testHistoryTab() {

       InfoTab tester = new HistoryTab("test", new Controller());

       assertEquals(0, tester.getTextIndex());
       tester.update(new Button("button"));
       assertEquals(1, tester.getTextIndex());
       tester.clear();
       assertEquals(0, tester.getTextIndex());
     } 
}
