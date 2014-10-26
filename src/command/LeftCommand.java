package command;

public class LeftCommand extends RotateCommand {

	public LeftCommand(String s){
		super(s,1);
	}

	@Override
	public int getDirection() {
		return LEFT;
	}


}
