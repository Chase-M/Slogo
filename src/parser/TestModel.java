package parser;

import java.lang.reflect.InvocationTargetException;
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
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testPosition() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Parser parser=new Parser();
		View view = new View();
		//Actor t=new Turtle(view);
		//parser.parse("forward 50");
		//Info info=new TurtleInfo(t);
		//assertEquals("50", ((TurtleInfo)info).getY());
	}
	/**
	 * Test to make sure it throws exceptions properly
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test(expected=Exception.class)	
	public void testParseException() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Parser parser = new Parser();
		parser.parse("asjklfhas;hgoask’dhfaga");
	}

	@Test
	public void testSumCommand(){
		List<Actor> list = null;
		Node sum = new Node(new SumCommand());
		sum.addChild(new Node(new IntCommand(5)));
		sum.addChild(new Node(new IntCommand(3)));
		assertEquals(8, sum.evaluate(list),PRECISION);
	}
	@Test
	public void testLessCommand(){
		List<Actor> list = null;
		Node sum = new Node(new LessCommand());
		sum.addChild(new Node(new IntCommand(2)));
		sum.addChild(new Node(new IntCommand(3)));
		assertEquals(1, sum.evaluate(list),PRECISION);
	}
}

