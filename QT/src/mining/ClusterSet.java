package mining;
import data.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe che rappresenta un insieme di cluster (determinati da QT)
 */

public class ClusterSet implements Iterable {
   // private Cluster C[] = new Cluster[0];
    private Set<Cluster> C = new TreeSet<>();

    public ClusterSet(){
    }

    /**
     * Aggiunge un nuovo cluster all'interno del mining.ClusterSet
     * @param c mining.Cluster da aggiungere
     */
    public void add(Cluster c){
        C.add(c);
    }

    @Override
    public Iterator<Cluster> iterator(){
        return C.iterator();
    }


    /**
     * Restituisce una stringa fatta da ciascun centroide dell'insieme dei cluster
     * @return
     */
    public String toString(){
        String result = "";
        for(Cluster c : C)
            result+= c.getCentroid() +",";

        return result;
    }

    // fornita
    public String toString(Data data){
        String str="";
        int i=0;
        for(Cluster c: C){
            i++;
            if(c!= null){
                str+=i+":"+c.toString(data)+"\n";
            }
        }
        return str;
    }
}
