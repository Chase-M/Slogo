package exceptions;

public class IncorrectNumInputsException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public IncorrectNumInputsException (String message) {
        super("IncorrectNumInputs", message);
    }

}
