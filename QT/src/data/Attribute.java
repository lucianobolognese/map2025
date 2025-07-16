package data;

import java.io.Serializable;

/**
 * Classe astratta data.Attribute che modella la entità attributo
 */
abstract class Attribute implements Serializable {
    /**
     * Nome simbolico dell'attributo
     */
    private String name;
    /**
     * Identificativo numerico dell'attributo 
     */
    private int index;

    /**
     * Inizializza i valori dei membri name, index
     * @param name nome attributo
     * @param index identificativo numerico dell'attributo
     */
    public Attribute(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * Restituisce name
     * @return nome attributo
     */
    public String getName(){
        return name;
    }

    /**
     * Restituisce index
     * @return indice
     */
    public int getIndex(){
        return index;
    }

    /**
     * Restituisce una stringa rappresentante  lo stato dell'oggetto
     * @return
     */
    @Override
    public String toString(){
        return name;
    }
}


