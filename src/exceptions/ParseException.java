package exceptions;

public class ParseException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String myMessage;
    public ParseException(String message){
       myMessage=String.format("Parse Exception: command %s was not found", message);
    }
    
    public String toString(){
        return myMessage;
        
    }
    
}
