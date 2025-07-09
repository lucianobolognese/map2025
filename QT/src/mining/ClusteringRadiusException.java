package mining;

/**
 * Eccezione controllata da considerare qualora l'algoritmo di clustering generi
 * un solo cluster
 */

public class ClusteringRadiusException extends Exception{
    /**
     * Costruttore con messaggio personalizzato
     * @param message
     */
    public ClusteringRadiusException(String message){
        super(message);
    }

    /*
    Costruttore di default
     */
    public ClusteringRadiusException(){
        super("L'algoritmo di clustering ha generato un solo cluster");
    }

    /**
     * Costruttore con messaggio e causa
     * @param message
     * @param cause
     */
    public ClusteringRadiusException(String message, Throwable cause) {
        super(message, cause);
    }
}
