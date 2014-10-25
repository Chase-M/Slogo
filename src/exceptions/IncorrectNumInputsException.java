package exceptions;

public class IncorrectNumInputsException extends CustomException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public IncorrectNumInputsException (String message) {
        super(String.format("Incorrect number of Inputs for command %s",message));
        // TODO Auto-generated constructor stub
    }

}
