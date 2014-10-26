package parser;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.List;
import org.junit.Test;
import workspace.Workspace;
import command.ConstCommand;
import command.LessCommand;
import command.SumCommand;

public class TestModel {

	private final static double PRECISION = 0.0000000001;
	/**
	 * Test to make sure it moves within the model properly
	 * @throws Exception 
	 */
	@Test
	public void testPosition() throws Exception{
		Parser parser=new Parser();
		Workspace workspace=new Workspace();
		List<Node> list = parser.parse("forward 50");
		assertEquals(50, list.get(0).evaluate(workspace), PRECISION);
	}
	/**
	 * Test to make sure it throws exceptions properly
	 */
	@Test(expected=Exception.class)	
	public void testParseException() throws Exception{
		Parser parser = new Parser();
		parser.parse("asjklfhas;hgoask’dhfaga");
	}		

	@Test
	public void testSumCommand() throws Exception{
		Node sum = new Node(new SumCommand("sum"));
		sum.addChild(new Node(new ConstCommand("5")));
		sum.addChild(new Node(new ConstCommand("3")));
		assertEquals(8, sum.evaluate(null),PRECISION);
	}
	@Test
	public void testLessCommand() throws Exception{
		Node sum = new Node(new LessCommand("less"));
		sum.addChild(new Node(new ConstCommand("2")));
		sum.addChild(new Node(new ConstCommand("3")));
		assertEquals(1, sum.evaluate(null),PRECISION);
	}
	@Test
	public void testWrite() throws Exception{
	    Workspace workspace=new Workspace();
	    Parser parser=new Parser();
	    List<Node> list=parser.parse("make :a 1 make :b 2 to square [ :var ] [ sum ( 90 101 10 )  fd 50 ]");
	    for(Node n: list){
	        n.evaluate(workspace);
	    }
	    File f=new File("writeTest.txt");
	    f.createNewFile();
	    workspace.writeMem(f);
	    
	}
}


