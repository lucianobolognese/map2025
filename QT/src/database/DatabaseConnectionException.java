package database;

public class DatabaseConnectionException extends Exception{

    /**
     * Costruttore con messaggio personalizzato
     * @param message
     */
    public DatabaseConnectionException(String message){ super(message);}

    /**
     * Costruttore di default
     */
    public DatabaseConnectionException(){
        super("Errore di connessione al Database");
    }

    /**
     * Costruttore con messaggio e causa
     * @param message
     * @param cause
     */
    public DatabaseConnectionException(String message, Throwable cause){
        super(message,cause);
    }
}
