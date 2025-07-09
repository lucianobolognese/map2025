package data;

/**
 * Modella una eccezione controllata da considerare qualora il dataset sia vuoto
 */

public class EmptyDatasetException extends Exception{

    /**
     * Costruttore con messaggio personalizzato
     * @param message
     */
    public EmptyDatasetException(String message){
        super(message);
    }

    /*
    Costruttore di default
   */
    public EmptyDatasetException(){
        super("Il Dataset risulta vuoto");
    }

    /**
     * Costruttore con messaggio e causa
     * @param message
     * @param cause
     */

    public EmptyDatasetException(String message, Throwable cause) {
        super(message,cause);
    }

}
