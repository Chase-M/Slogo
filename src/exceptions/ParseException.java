package exceptions;

public class ParseException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ParseException (String message) {
        super(String.format("Parse Exception: command %s was not found", message));
    }

}
