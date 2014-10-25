package command;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import actor.Turtle;
import parser.Node;
import workspace.Workspace;

public class TellCommand extends Command {

	public TellCommand(String s) {
		super(s,1);
		myNumLists = 1;
	}

	@Override
	public double execute(List<Node> inputs, Workspace workspace) {
		Map<Integer,Turtle> map = workspace.getTurtles();
		Set<Integer> ids = new HashSet<>();
		int id = 0;
		for(int i = 1; i<inputs.size()-1; i++){
			id = (int) inputs.get(i).evaluate(workspace);
			if(!map.containsKey(id)){
				workspace.createTurtle(id);
			}
			ids.add(id);
		}
		for(Integer i: map.keySet()){
			map.get(i).setActive(ids.contains(i));
		}

		return id;
	}

}
