package data;

import java.io.Serializable;

/**
 * Classe che estende la classe Item e modella una coppia <Attributo continuo - valore numerico>
 *    per esempio Temperature=30.5
 */

public class ContinuousItem extends Item implements Serializable {

    /**
     * Richiama il costruttore della super classe
     * @param attribute
     * @param value
     */
    public ContinuousItem(Attribute attribute, Double value){
        super(attribute,value);
    }

    /**
     * Calcola la distanza normalizzata tra this oggetto ContinuousItem e un altro oggetto.
     *
     * Il calcolo viene effettuato in base al valore numerico scalato (normalizzato) degli item
     * secondo l'intervallo definito dall'attributo continuo associato (min, max).
     * In valore assoluto
     *
     * @param a
     * @return dist
     */
    @Override
    public double distance(Object a){
        if (a instanceof ContinuousItem) {
            ContinuousItem other = (ContinuousItem) a;
            double val1 = ((ContinuousAttribute) this.getAttribute()).getScaledValue((double)this.getValue());
            double val2 = ((ContinuousAttribute) other.getAttribute()).getScaledValue((double)other.getValue());
            return Math.abs(val1 - val2);
        } else if (a instanceof Number) {
            double val1 = ((ContinuousAttribute) this.getAttribute()).getScaledValue((double)this.getValue());
            double val2 = ((ContinuousAttribute) this.getAttribute()).getScaledValue(((Number) a).doubleValue());
            return Math.abs(val1 - val2);
        } else {
            // fallback robusto in caso di errori
            try {
                double val2 = Double.parseDouble(a.toString());
                double val1 = ((ContinuousAttribute) this.getAttribute()).getScaledValue((double)this.getValue());
                val2 = ((ContinuousAttribute) this.getAttribute()).getScaledValue(val2);
                return Math.abs(val1 - val2);
            } catch (NumberFormatException e) {
                return Double.MAX_VALUE;
            }
        }
    }


}
