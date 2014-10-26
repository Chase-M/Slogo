package exceptions;

public class IncorrectInputException extends CustomException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public IncorrectInputException (String message) {
        super(String.format("Incorrect type of inputs for %s", message));
        
    }

}
