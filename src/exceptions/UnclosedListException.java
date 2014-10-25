package exceptions;

public class UnclosedListException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public UnclosedListException(String message){
        super("error parsing, unclosed list");
    }
}
