package mining;
import utility.ArraySet;
import data.Data;

import data.Tuple;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe mining.Cluster che modella un cluster
 */
class Cluster implements Iterable<Integer>,Comparable<Cluster>, Serializable {
	private Tuple centroid;

	private Set<Integer> clusteredData = new HashSet<Integer>();
	
	/*mining.Cluster(){
		
	}*/

	Cluster(Tuple centroid){
		this.centroid=centroid;
		
	}
		
	Tuple getCentroid(){
		return centroid;
	}
	
	//return true if the tuple is changing cluster
	boolean addData(int id){
		return clusteredData.add(id);
		
	}
	
	//verifica se una transazione è clusterizzata nell'array corrente
	boolean contain(int id){
		return clusteredData.contains(id);
	}
	

	// rimuovi la tupla che ha cambiato il cluster
	void removeTuple(int id){
		clusteredData.remove(id);
	}
	
	int getSize(){
		return clusteredData.size();
	}
	
	@Override
	public Iterator<Integer> iterator(){
		return clusteredData.iterator();
	}

	/**
 	* Implementazione del compareTo
 	* @param other
 	* @return
 	*/
	@Override
	public int compareTo(Cluster other) {
		if (this.getSize() < other.getSize()) {
			return -1;
		} else if (this.getSize() > other.getSize()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString(){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i);
		str+=")";
		return str;
		
	}

	public String toStringshort2(Data data){
		String str ="Centroid=(";
		for(int i=0; i<centroid.getLength();i++)
			str+=centroid.get(i);
		str+=")";
		return str;
	}


	
	public String toString(Data data){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i)+ " ";
		str+=")\nExamples:\n";

		for(int i:clusteredData){
			str+="[" +data.getItemSet(i).toString()+"] dist=" +getCentroid().getDistance(data.getItemSet(i)) +"\n";
		}
		/*
		int array[]=clusteredData.toArray();
		for(int i=0;i<array.length;i++){
			str+="[";
			for(int j=0;j<data.getNumberofExplanatoryAttributes();j++)
				str+=data.getValue(array[i], j)+" ";
			str+="] dist="+getCentroid().getDistance(data.getItemSet(array[i]))+"\n";
			
		}

		 */
		str+="\nAvgDistance="+getCentroid().avgDistance(data, clusteredData)+"\n";
		return str;
		
	}

}


