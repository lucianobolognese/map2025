package database;

/**
 * Modella la restituzione di un resultset vuoto
 */
public class EmptySetException extends Exception{
    public EmptySetException(String message){
        super(message);
    }

    public EmptySetException(String message, Throwable cause){
        super(message,cause);
    }
}
