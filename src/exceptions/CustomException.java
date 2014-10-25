package exceptions;

public class CustomException extends RuntimeException{

    /**
     * 
     */
    protected static final long serialVersionUID = 1L;
    private String myMessage;
    public CustomException(String message){
        setMessage(message);
    }
    public void setMessage(String message){
        myMessage=message;
    }
    public String toString(){
        return myMessage;
    }
}
