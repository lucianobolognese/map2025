package database;

public class EmptyTypeException extends Exception{
    public EmptyTypeException(String message){
        super(message);
    }

    public EmptyTypeException(String message, Throwable cause){
        super(message, cause);
    }

}
