package exceptions;

public class IncorrectIndexException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public IncorrectIndexException (int index) {
        super("IncorrectIndex", index);
    }

}
