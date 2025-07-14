package mining;
import data.Data;

import java.util.Iterator;
import java.util.Set;

/**
 * Classe che include l'implementazione dell'algoritmo QT
 */

public class QTMiner {
    private ClusterSet C;
    private double radius;

    /**
     * Crea l'oggetto array riferito da C e inizializza radius con il parametro passato come input
     * @param radius
     */
    public QTMiner(double radius){
        C = new ClusterSet();
        this.radius = radius;
    }

    /**
     * Restituisce C
     * @return
     */
    public ClusterSet getC(){
        return C;
    }

    /**
     * Fornita
     * Esegue l'algoritmo QT eseguendo i passi dello pseudo-codice:
     * 1. Costruisce un cluster per ciascuna tupla non ancora clusterizzata, includendo nel cluster i punti
     * (non ancora clusterizzati in alcun altro cluster) che ricadano nel vicinato sferico della tupla
     * avente raggio radius
     * 2. Salva il candidato cluster più popoloso e rimuove tutti punti di tale cluster dall'elenco delle tuple
     * ancora da clusterizzare
     * 3. Ritorna al passo 1 finchè ci sono ancora tuple da assegnare ad un cluster
     * @param data
     * @return
     */
    public int compute(Data data) throws ClusteringRadiusException{
        int numclusters=0;
        boolean isClustered[] = new boolean[data.getNumberOfExamples()];

        for(int i=0; i<isClustered.length;i++){
            isClustered[i]=false;
        }

        int countClustered=0;

        while(countClustered!=data.getNumberOfExamples())
        {
            // Ricerca cluster più popoloso
            Cluster c = buildCandidateCluster(data, isClustered);

            // CONTROLLO IMPORTANTE: Se non ci sono più cluster possibili, esci
            if(c == null || c.getSize() == 0) {
                break;
            }

            C.add(c);
            numclusters++;

            // Marca come clusterizzate le tuple del cluster
            for(Integer tupleID : c){
                isClustered[tupleID] = true;
            }

            countClustered += c.getSize();
        }

        if(numclusters ==1){
            throw new ClusteringRadiusException("Solo un cluster generato dall'algoritmo");
        }

        return numclusters;
    }

    /**
     * Costruisce un cluster per ciascuna tupla di data non ancora clusterizzata in un cluster di C
     * e restituisce il cluster candidato più popoloso
     * @param data insieme di tuple da raggruppare in cluster
     * @param isClustered informazione booleana sullo stato di clusterizzazione di una tupla
     */
    Cluster buildCandidateCluster(Data data, boolean isClustered[]){
        Cluster bestCluster = null;
        int maxSize = -1;

        for(int i=0; i < data.getNumberOfExamples(); i++){
            if(isClustered[i]) continue;
            
            // Costruisco un nuovo cluster candidato con centro la tupla i
            Cluster candidate = new Cluster(data.getItemSet(i));

            // Aggiunge il centro del cluster
            candidate.addData(i);

            for(int j=0; j< data.getNumberOfExamples(); j++){
                if(!isClustered[j] && i != j){
                    double distance = data.getItemSet(i).getDistance(data.getItemSet(j));

                    if(distance <= radius) {
                        candidate.addData(j);
                    }
                }
                /*
                if(!isClustered[j] && data.getItemSet(i).getDistance(data.getItemSet(j)) <= radius) {
                    candidate.addData(j);
                }
                 */
            }


            // Se il cluster più popoloso finora, lo salvo
            if(candidate.getSize() > maxSize) {
                bestCluster = candidate;
                maxSize = candidate.getSize();
            }

        }
        return bestCluster;
    }

}
