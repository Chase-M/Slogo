package parser;

import java.util.List;

import org.junit.Test;

import command.IntCommand;
import command.LessCommand;
import command.SumCommand;
import view.View;
import actor.Actor;
import actor.Info;
import actor.Turtle;
import actor.TurtleInfo;
import static org.junit.Assert.*;

public class TestModel {
	
	private final static double PRECISION = 0.0000000001;
	/**
	 * Test to make sure it moves within the model properly
	 */
	@Test
	public void testPosition(){
		Parser parser=new Parser();
		View view = new View();
		Actor t=new Turtle(view);
		parser.parse("forward 50");
		Info info=new TurtleInfo(t);
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
	public void testSumCommand(){
		List<Actor> list = null;
		Node sum = new Node(new SumCommand(list));
		sum.addChild(new Node(new IntCommand(list,5)));
		sum.addChild(new Node(new IntCommand(list,3)));
		assertEquals(8, sum.evaluate(),PRECISION);
	}
	@Test
	public void testLessCommand(){
		List<Actor> list = null;
		Node sum = new Node(new LessCommand(list));
		sum.addChild(new Node(new IntCommand(list,2)));
		sum.addChild(new Node(new IntCommand(list,3)));
		assertEquals(1, sum.evaluate(),PRECISION);
	}
}
