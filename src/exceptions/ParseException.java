package exceptions;

public class ParseException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ParseException (String message) {
        super("ParseException", message);
    }

}
