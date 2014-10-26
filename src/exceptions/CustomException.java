package exceptions;

/**
 * @author Timesh Patel, Chase Malik
 */
import properties.LanguageProperties;


public class CustomException extends RuntimeException {

    /**
     * base exception for Custom exceptions to handle errors in slogo
     */
    protected static final long serialVersionUID = 1L;

    private final String myMessage;

    public CustomException (String message, Object ... o) {
        LanguageProperties props = new LanguageProperties();
        myMessage = String.format(props.getResourceBundle().getString(message), o);
    }

    public String toString () {
        return myMessage;
    }
}
