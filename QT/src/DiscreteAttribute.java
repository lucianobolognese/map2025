/**
 * Estende la classe Attribute e rappresenta un attributo discreto e categorico
 */
public class DiscreteAttribute extends Attribute{
    /**
     * Array di oggetti String, uno per ciascun valore del dominio discreto.
     * I valori del dominio sono memorizzati in values seguendo un ordine lessicografico
     */
    private String values[];

    /**
     * Invoca il costruttore della classe madre e inizializza il membro values con il parametro
     * in input
     * @param name nome attributo
     * @param index identificativo numerico dell'attributo
     * @param values array di stringhe rappresentanti il dominio dell'attributo
     */
    public DiscreteAttribute(String name, int index, String values[])
    {
        super(name,index);
        this.values = values;
    }

    /**
     * Restituisce la dimensione di values
     * @return numero di valori discreti nel dominio dell'attributo
     */
    public int getNumberofDistinctValues()
    {
        return values.length;
    }

    /**
     * Restituisce values[i]
     * @param i posizione di un valore in values
     * @return valore discreto in posizione "i" di values
     */
    public String getValue(int i){
        return values[i];
    }
}
