/**
 * Rappresenta una tupla come sequenza di coppie attributo-valore
 */
public class Tuple {
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
    double getDistance(Tuple obj){
        double distance=0;
        for(int i=0; i<getLength(); i++){
            distance += this.tuple[i].distance(obj.tuple[i]);
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
    double avgDistance(Data data, int clusteredData[]){
        double p=0.0, sumD=0.0;
        for(int i=0; i< clusteredData.length; i++){
            double d=getDistance(data.getItemSet(clusteredData[i]));
            sumD += d;
        }
        p = sumD/ clusteredData.length;
        return p;
    }
}
