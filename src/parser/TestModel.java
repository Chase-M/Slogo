package parser;

import org.junit.Test;

import command.IntCommand;
import command.SumCommand;
import view.View;
import actor.Actor;
import actor.ActorInfo;
import actor.Turtle;
import actor.TurtleInfo;
import static org.junit.Assert.*;

public class TestModel {
	/**
	 * Test to make sure it moves within the model properly
	 */
	@Test
	public void testPosition(){
		Parser parser=new Parser();
		View view = new View();
		Actor t=new Turtle(view);
		parser.parse("forward 50");
		ActorInfo info=new TurtleInfo(t);
		assertEquals("50", ((TurtleInfo)info).getY());
	}
	/**
	 * Test to make sure it throws exceptions properly
	 */
	@Test(expected=Exception.class)	
	public void testParseException(){
		Parser parser = new Parser();
		parser.parse("asjklfhas;hgoask’dhfaga");
	}
	
	@Test
	public void testNodeBehavior(){
		Node sum = new Node(new SumCommand());
		sum.addChild(new Node(new IntCommand(5)));
		sum.addChild(new Node(new IntCommand(3)));
		assertEquals(8, sum.evaluate());
	}
}
