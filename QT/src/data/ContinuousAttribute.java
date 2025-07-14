package data;

/**
 * Estende la classe data.Attribute e modella un attributo continuo (numerico).
 * Tale classe include i metodi per scalare l'attributo dal dominio dell'attributo all'intervalllo [0,1]
 * al fin di rendere confrontabili attributi aventi domini diversi
 */
public class ContinuousAttribute extends Attribute {
    /**
     * Rappresentano gli estremi dell'intervallo di valori (dominio)
     */
    private double max;
    private double min;

    /**
     * Invoca il costruttore della classe madre e inizializza i membri aggiunti per estensione
     * @param name nome
     * @param index identificativo numerico
     * @param min valore minimo attributo nel suo dominio
     * @param max valore massimo attributo nel suo dominio
     */
    public ContinuousAttribute(String name, int index, double min, double max)
    {
        super(name,index);
        this.max = max;
        this.min = min;
    }

    /**
     * Calcola e restituisce il valore scalato del parametro passato in input.
     * Lo scaling ha come codominio l'intervallo [0,1]
     * Lo scaling di v è quindi calcolato : v' = (v-min)/(max-min)
     * @param v
     * @return
     */
    double getScaledValue(double v)
    {
        double result;
        result = (v-min) / (max-min);
        return result;
    }

}
