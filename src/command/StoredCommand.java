package command;

import java.util.List;
import parser.CommandObject;
import parser.Node;
import workspace.Workspace;
import exceptions.IncorrectNumInputsException;
import exceptions.ParseException;


public class StoredCommand extends BaseMakeVariableCommand {

    public StoredCommand (String s) {
        super(s, 1, 1);
    }

    @Override
    public double execute (List<Node> inputs, Workspace workspace) throws Exception {
        if(!workspace.getCommands().containsKey(toString()))
            throw new ParseException(toString());
        checkListException(inputs);
        CommandObject command = workspace.getCommands().get(myString);
        List<String> names = command.getMyVarNames();
        List<Node> commands = command.getMyCommands();
        double ans = 0;
        if (command.getMyNumVars() == inputs.size() - 2) {
            for (int i = 1; i < inputs.size() - 1; i++) {
          
                makeVariable(names.get(i - 1), inputs.get(i).evaluate(workspace), workspace);

            }

            for (int i = 0; i < commands.size() - 1; i++) {
                ans = commands.get(i).evaluate(workspace);
            }
        }
        else {
            throw new IncorrectNumInputsException(toString());
        }
        return ans;
    }
    
   
}
