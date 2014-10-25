package exceptions;

public class NotEnoughInputsException extends CustomException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotEnoughInputsException (String message) {
        super(String.format("Not Enough Inputs for command %s",message));
        // TODO Auto-generated constructor stub
    }

}
