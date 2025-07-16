package data;

import java.io.Serializable;
import java.util.Set;

/**
 * Rappresenta una tupla come sequenza di coppie attributo-valore
 */
public class Tuple implements Serializable {
    private Item[] tuple;

    /**
     * Costruisce l'oggetto riferito da tuple
     * @param size dimensione
     */
    public Tuple(int size){
        tuple = new Item[size];
    }

    /**
     * Restituisce tuple.length
     * @return
     */
    public int getLength(){
        return tuple.length;
    }

    /**
     * Restituisce l'item in posizione i
     * @param i
     * @return
     */
    public Item get(int i){
        return tuple[i];
    }

    /**
     * Memorizza c in tuple[i]
     * @param c item da memorizzare
     * @param i indice
     */
    void add(Item c, int i){
        tuple[i] = c;
    }

    /**
     * Determina la distanza tra la tupla riferita da obj e la tupla corrente (riferita da this)
     * La distanza è ottenuta come la somma delle distanza tra gli item in posizioni eguali nelle due tuple.
     *
     * @param obj typla da confrontare
     * @return distance somma delle distanze tra item nelle posizioni uguali delle due tuple
     */
    public double getDistance(Tuple obj){
        double distance=0.0;
        int length = this.getLength();

        for(int i=0; i<length; i++){
            Object value2 = obj.get(i).getValue();
            distance += this.get(i).distance(value2);
            //distance += this.tuple[i].distance(obj.tuple[i]);
        }
        return distance;
    }

    /**
     * Restituisce la media delle distanze tra la tupla corrente e quelle ottenibili dalle righe
     * della matrice in data aventi indice in clusteredData
     * @param data
     * @param clusteredData
     * @return average distance
     */
    public double avgDistance(Data data, Set<Integer> clusteredData){
        double p=0.0, sumD=0.0;

        for(int i : clusteredData){
            double d = getDistance(data.getItemSet(i));
            sumD += d;
        }

        p=sumD/clusteredData.size();
        return p;
    }

    /**
     * Sovrascrive toString per utilizzarlo con le tuple
     * @return sb.toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();;

        for (int i = 0; i < tuple.length; i++) {
            sb.append(tuple[i].toString());
            if (i < tuple.length - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

}
