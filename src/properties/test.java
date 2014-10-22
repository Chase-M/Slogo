package properties;
 
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
 
public class test {
 
    public static void main(String[] args) {
 
        // Use Java Collections to create the List
        List<Position> list = new ArrayList<Position>();
        list.add(new Position(0, 0, 0));
        
        // Now add observability by wrapping it with ObservableList
       ObservableList<Position> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });
        
        // Sort using FXCollections
        observableList.get(0).setAngle(10);
        observableList.set(0, observableList.get(0));
    }
}