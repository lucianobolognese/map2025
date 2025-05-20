/**
 * Classe che rappresenta un insieme di cluster (determinati da QT)
 */

public class ClusterSet {
    private Cluster C[] = new Cluster[0];

    public ClusterSet(){
    }

    /**
     * Aggiunge un nuovo cluster all'interno del ClusterSet
     * @param c Cluster da aggiungere
     */
    public void add(Cluster c){
        Cluster tempC[] = new Cluster[C.length+1];
        for(int i=0; i<C.length; i++)
            tempC[i]=C[i];
        tempC[C.length] = c;
        C=tempC;
    }

    /**
     * Restituisce il Cluster all'indice i
     * @param i indice
     * @return C[i]
     */
    Cluster get(int i){
        return C[i];
    }

    /**
     * Restituisce una stringa fatta da ciascun centroide dell'insieme dei cluster
     * @return
     */
    public String toString(){
        String result = "";
        for(int i=0; i<C.length; i++){
            result+= C[i].getCentroid() +",";
        }
        return result;
    }

    // fornita
    public String toString(Data data){
        String str="";
        for(int i=0; i<C.length; i++){
            if(C[i]!= null){
                str+=i+":"+C[i].toString(data)+"\n";
            }
        }
        return str;
    }
}
