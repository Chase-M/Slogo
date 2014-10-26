package command;

public class RightCommand extends RotateCommand {

	public RightCommand(String s){
		super(s,1);
	}

	@Override
	public int getDirection() {
		return RIGHT;
	}


}
