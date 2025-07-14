package data;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Estende la classe data.Attribute e rappresenta un attributo discreto e categorico
 */
public class DiscreteAttribute extends Attribute {
    /**
     * Treeset di oggetti String, uno per ciascun valore del dominio discreto.
     * I valori del dominio sono memorizzati in values seguendo un ordine lessicografico
     */

    private TreeSet<String> values;

    /**
     * Invoca il costruttore della classe madre e inizializza il membro values con il parametro
     * in input
     * @param name nome attributo
     * @param index identificativo numerico dell'attributo
     * @param values array di stringhe rappresentanti il dominio dell'attributo
     */
    public DiscreteAttribute(String name, int index, TreeSet<String> values)
    {
        super(name,index);
        this.values = values;
    }

    public Iterator<String> iterator(){
        return values.iterator();
    }

    /**
     * Restituisce la dimensione di values
     * @return numero di valori discreti nel dominio dell'attributo
     */
    public int getNumberofDistinctValues()
    {
        return values.size();
    }

    /**
     * eliminare
     * Restituisce values[i]
     * @param i posizione di un valore in values
     * @return valore discreto in posizione "i" di values
     */
    /*public String getValue(int i){
        String value = values.iterator().next();

        int counter=0;
        for(String val:values){
            value+=val;
        }
        return value;
    }
     */
}
