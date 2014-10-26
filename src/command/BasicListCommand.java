package command;

import java.util.List;
import exceptions.NotEnoughListsException;
import parser.Node;


public abstract class BasicListCommand extends Command {
    private int myNumLists;
    private int myCheckList;

    public BasicListCommand (String s, int numInputs, int numLists) {
        super(s, numInputs);
        myNumLists = numLists;
        myCheckList = myNumLists;
    }

    @Override
    public boolean checkListExit (Node node) {
        myCheckList--;
        return node.getCommand() instanceof ListEndCommand && myCheckList == 0;
    }

    public void checkListException (List<Node> inputs) throws Exception {
        int numLists = 0;

        for (Node n : inputs) {
            if (n.getCommand() instanceof ListEndCommand) {
                numLists++;
            }
        }
        if (numLists != myNumLists) {
            throw new NotEnoughListsException(toString());
        }

    }

    public int getBracketIndex (List<Node> inputs) {
        int index = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).getCommand() instanceof ListEndCommand) {
                index = i;
                break;
            }
        }
        return index;
    }

}
