package exceptions;

public class CustomException extends RuntimeException {

    /**
     * 
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
