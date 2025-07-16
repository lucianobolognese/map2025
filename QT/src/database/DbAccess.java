package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Realizza l'accesso alla base di dati
 */
public class DbAccess {
    private String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final String DBMS = "jdbc:mysql";
    /**
     * Contiene l'identificativo del server su cui risiede la base di dati
     */
    private final String SERVER = "localhost";
    /**
     * Contiene il nome della base di dati
     */
    private final String DATABASE = "MapDB";
    /**
     * La porta su cui il DBMS MySQL accetta le connessioni
     */
    private final String PORT = "3306";

    /**
     * Contiene il nome dell'utente per l'accesso alla base di dati
     */
    private final String USER_ID = "MapUser";

    /**
     * Contiene la password di autenticazione per l'utente identificato
     * da USER_ID
     */
    private final String PASSWORD = "map";

    /**
     * Gestisce una connessione
     */
    private Connection conn;

    /**
     * Impartisce al class loader l'ordine di caricare il driver mysql, inizializza la connessione riferita da conn
     * Il metodo solleva e propaga una eccezione di tipo DatabaseConnectionException in caso di fallimento
     * nella connessione al database
     *
     * Suggerimento: Stringa di connessione: DBMS + "://" + SERVER + ":" + PORT +"/"+ DATABASE + "?user="+USER_ID +
     * + "&password=" + PASSWORD + "&serverTimezone=UTC";
     * @throws DatabaseConnectionException
     */
    public void initConnection() throws DatabaseConnectionException{
        try {
            // carica il driver mysql
            Class.forName(DRIVER_CLASS_NAME).newInstance();
        } catch (ClassNotFoundException e) {
            throw new DatabaseConnectionException("[!} Driver MYSQL not found", e);
        } catch (InstantiationException e1){
            e1.printStackTrace();
        } catch (IllegalAccessException e2){
            System.out.println("[!] Cannot access the driver: "+ e2.getMessage());
        }

        String connectionString = DBMS + "://" + SERVER + ":" + PORT +"/"+ DATABASE + "?user="+USER_ID
                + "&password=" + PASSWORD + "&serverTimezone=UTC";
        System.out.println("Connection's String: "+connectionString);

        try{
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("[!] SQLException: "+e.getMessage());
            System.out.println("[!] SQLState: "+e.getSQLState());
            System.out.println("[!] VendorError: "+e.getErrorCode());
        }

    }

    public Connection getConnection(){
        return conn;
    }

    public void closeConnection() throws SQLException{
        conn.close();
    }
}
