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
	
	@Test
	public void TestSum2(){
		Parser p=new Parser();
		List<Node> list=p.parse("sum 20 20 sum 15 15");
		
		assertEquals(40,list.get(0).evaluate(null), .00000001);
		assertEquals(30,list.get(1).evaluate(null), .00000001);
	}
}
