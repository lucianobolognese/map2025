/**
 * Estende la classe Attribute e modella un attributo continuo (numerico).
 * Tale classe include i metodi per scalare l'attributo dal dominio dell'attributo all'intervalllo [0,1]
 * al fin di rendere confrontabili attributi aventi domini diversi
 */
public class ContrinuousAttribute extends Attribute {
    /**
     * Rappresentano gli estremi dell'intervallo di valori (dominio)
     */
    private double max;
    private double min;

    /**
     * Inizializza i valori dei membri name, index
     *
     * @param name  nome attributo
     * @param index identificativo numerico dell'attributo
     */
    public ContrinuousAttribute(String name, int index) {
        super(name, index);
    }
}
