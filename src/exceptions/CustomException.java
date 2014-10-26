package exceptions;

import properties.LanguageProperties;

public class CustomException extends RuntimeException {

    /**
     * 
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
