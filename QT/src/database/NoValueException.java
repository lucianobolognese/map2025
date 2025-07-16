package database;

/**
 * Modella l'assenza di un valore all'interno di un resultset
 */
public class NoValueException extends Exception{
    public NoValueException(String message){
        super(message);
    }

    public NoValueException(String message, Throwable cause){
        super(message,cause);
    }

}
