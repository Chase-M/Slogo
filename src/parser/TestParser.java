package parser;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import actor.Turtle;

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
		List<Node> list=p.parse("+ 20 20 sum 15 15");
		
		assertEquals(40,list.get(0).evaluate(null), .00000001);
		assertEquals(30,list.get(1).evaluate(null), .00000001);
	}

	
	@Test
	public void TestForward(){
		Parser p=new Parser();
		Turtle turtle = new Turtle(0,0,Math.PI/2);
		List<Node> list=p.parse("forward 50");
		assertEquals(50,list.get(0).evaluate(turtle), .00000001);
	}

        @Test
        public void TestMake(){
                Parser p=new Parser();
                List<Node> list=p.parse("make :var sum sum 1 1 20 sum :var 15");

                assertEquals(0,list.get(0).evaluate(null), .00000001);
                assertEquals(37,list.get(1).evaluate(null), .00000001);
        }
        @Test
        public void TestRepeat(){
                Parser p=new Parser();
                List<Node> list=p.parse("make :a 0 repeat 5 [ sum 5 5 ] sum 10 10");
                assertEquals(20,list.get(2).evaluate(null), .00000001);
        }
        @Test
        public void TestFor(){
                Parser p=new Parser();
                List<Node> list=p.parse("for [ 0 10 1 ] [ sum 5 5 ] sum 10 10");
                assertEquals(20,list.get(1).evaluate(null), .00000001);
        }


}
