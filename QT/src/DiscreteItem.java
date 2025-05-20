/**
 * Classe DiscreteItem che estende la classe Item e rappresenta una coppia <Attributo discreto - valore discreto>
 *    per esempio Outlook="Sunny")
 */

public class DiscreteItem extends Item {
    /**
     * Invoca il costruttore della classe madre
     * @param attribute
     * @param value
     */
    public DiscreteItem(DiscreteAttribute attribute, String value){
        super(attribute,value);
    }

    /**
     * Restituisce 0 se a è uguale a getValue(), altrimenti 1
     * @param a
     * @return
     */
    public double distance(Object a) {
        if(this.getValue().equals(a))
            return 0.0;
        else
            return 1.0;
    }
}
