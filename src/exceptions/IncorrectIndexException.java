package exceptions;

public class IncorrectIndexException extends CustomException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public IncorrectIndexException(int index){
       super(String.format("Index Out of Bounds Exception: index %d was not found", index));
    }
 
    
}
