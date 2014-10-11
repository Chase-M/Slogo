package parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import command.ConstCommand;
import command.LessCommand;
import command.SumCommand;
import view.View;
import actor.Turtle;
import static org.junit.Assert.*;

public class TestModel {

	private final static double PRECISION = 0.0000000001;
	/**
	 * Test to make sure it moves within the model properly
	 */
	@Test
	public void testPosition(){
		Parser parser=new Parser();
		Turtle t=new Turtle(0,0,Math.PI/2);
		List<Turtle> tList = new ArrayList<>();
		tList.add(t);
		List<Node> list = parser.parse("forward 50");
		assertEquals(50, list.get(0).evaluate(tList), PRECISION);
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
		Node sum = new Node(new SumCommand());
		sum.addChild(new Node(new ConstCommand("5")));
		sum.addChild(new Node(new ConstCommand("3")));
		assertEquals(8, sum.evaluate(null),PRECISION);
	}
	@Test
	public void testLessCommand(){
		Node sum = new Node(new LessCommand());
		sum.addChild(new Node(new ConstCommand("2")));
		sum.addChild(new Node(new ConstCommand("3")));
		assertEquals(1, sum.evaluate(null),PRECISION);
	}
}

