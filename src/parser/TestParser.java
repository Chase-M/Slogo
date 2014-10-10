package parser;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestParser {
    @Test
    public void TestSum(){
    Parser p=new Parser();
    List<Node> list=p.parse("sum sum 20 15 15");
    for(Node n: list){
        assertEquals(50,n.evaluate(null), .00000001);
    }
}
}
