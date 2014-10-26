package command;

public class ForwardCommand extends MoveCommand {
	public ForwardCommand(String s){
		super(s,1);
	}
	
	@Override
	public int getDirection() {
		return FORWARD;
	}

}
