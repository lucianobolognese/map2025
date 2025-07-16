package data;

import java.io.Serializable;

/**
 * Classe astratta che modella un generico item (coppia attributo-valore, esempio Outlook="Sunny")
 */

abstract class Item implements Serializable {
    /**
     * Attributo coinvolto nell'item
     */
    Attribute attribute;

    /**
     * Valore assegnato all'attributo
     */
    Object value;

    /**
     * Inizializza i valori dei membri attributi
     * @param attribute
     * @param value
     */
    public Item(Attribute attribute, Object value){
        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Restituisce attribute
     * @return attribute
     */
    public Attribute getAttribute(){
        return attribute;
    }

    /**
     * Restituisce value
     * @return value
     */
    public Object getValue(){
        return value;
    }


    /**
     * Restituisce value
     * @return value.toString()
     */
    public String toString(){
        return value.toString();
    }

    public abstract double distance(Object a);
}

