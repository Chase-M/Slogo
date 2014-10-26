package command;

public class BackCommand extends MoveCommand {
    public BackCommand (String s) {
        super(s, 1);
    }

    @Override
    public int getDirection () {
        return BACKWARD;
    }

}
