package exceptions;

public class NotEnoughListsException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotEnoughListsException (String message) {
        super(String.format("%s does not have enough lists", message));
    }

}
