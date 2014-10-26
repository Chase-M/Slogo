package exceptions;
/**
 * @author Timesh Patel, Chase Malik
 */
public class CustomException extends RuntimeException {

    /**
     *  base exception for Custom exceptions to handle errors in slogo
     */
    protected static final long serialVersionUID = 1L;

    private final String myMessage;

    public CustomException (String message) {
        myMessage = message;
    }

    public String toString () {
        return myMessage;
    }
}
