package data;

/**
 * Classe concreta per modellare l'insieme di transazioni (o tuple o anche denominati esempi)
 */
public class Data {
	/**
	 * matrice n x m di tipo Object dove ogni riga modella una transazione descritta
	 * dagli attributi riportati sulle colonne (n: righe, m: colonne)
	 */
	private Object data [][];
	/**
	 * cardinalità dell'insieme di transazioni (numero di righe in data)
	 */
	private int numberOfExamples;
	/**
	 * vettore degli attributi in ciascuna tupla (schema della tabella di dati)
	 */
	private Attribute explanatorySet[];
	
	
	public Data() throws EmptyDatasetException{
		
		//data
		
		data = new Object [14][5];

		data[0][0] = "sunny";
		data[0][1] = "hot";
		data[0][2] = "high";
		data[0][3] = "weak";
		data[0][4] = "no";

		data[1][0] = "sunny";
		data[1][1] = "hot";
		data[1][2] = "high";
		data[1][3] = "strong";
		data[1][4] = "no";

		data[2][0] = "overcast";
		data[2][1] = "hot";
		data[2][2] = "high";
		data[2][3] = "weak";
		data[2][4] = "yes";

		data[3][0] = "rain";
		data[3][1] = "mild";
		data[3][2] = "high";
		data[3][3] = "weak";
		data[3][4] = "yes";

		data[4][0] = "rain";
		data[4][1] = "cool";
		data[4][2] = "normal";
		data[4][3] = "weak";
		data[4][4] = "yes";

		data[5][0] = "rain";
		data[5][1] = "cool";
		data[5][2] = "normal";
		data[5][3] = "strong";
		data[5][4] = "no";

		data[6][0] = "overcast";
		data[6][1] = "cool";
		data[6][2] = "normal";
		data[6][3] = "strong";
		data[6][4] = "yes";

		data[7][0] = "sunny";
		data[7][1] = "mild";
		data[7][2] = "high";
		data[7][3] = "weak";
		data[7][4] = "no";

		data[8][0] = "sunny";
		data[8][1] = "cool";
		data[8][2] = "normal";
		data[8][3] = "weak";
		data[8][4] = "yes";

		data[9][0] = "rain";
		data[9][1] = "mild";
		data[9][2] = "normal";
		data[9][3] = "weak";
		data[9][4] = "yes";

		data[10][0] = "sunny";
		data[10][1] = "mild";
		data[10][2] = "normal";
		data[10][3] = "strong";
		data[10][4] = "yes";

		data[11][0] = "overcast";
		data[11][1] = "mild";
		data[11][2] = "high";
		data[11][3] = "strong";
		data[11][4] = "yes";

		data[12][0] = "overcast";
		data[12][1] = "hot";
		data[12][2] = "normal";
		data[12][3] = "weak";
		data[12][4] = "yes";

		data[13][0] = "rain";
		data[13][1] = "mild";
		data[13][2] = "high";
		data[13][3] = "strong";
		data[13][4] = "no";


		// numberOfExamples
		
		 numberOfExamples=14;

		 if(numberOfExamples == 0){
			 throw new EmptyDatasetException("Il dataset risulta vuoto");
		 }
		 
		
		//explanatory Set
		
		explanatorySet = new Attribute[5];

		
		String outLookValues[]=new String[3];
		outLookValues[0]="overcast";
		outLookValues[1]="rain";
		outLookValues[2]="sunny";
		explanatorySet[0] = new DiscreteAttribute("Outlook",0, outLookValues);

		String temperatureValues[]=new String[3];
		temperatureValues[0]="hot";
		temperatureValues[1]="mild";
		temperatureValues[2]="cool";
		explanatorySet[1] = new DiscreteAttribute("Temperature",1, temperatureValues);

		String humidityValues[]=new String[2];
		humidityValues[0]="high";
		humidityValues[1]="normal";
		explanatorySet[2] = new DiscreteAttribute("Humidity",2, humidityValues);

		String windValues[]=new String[2];
		windValues[0]="weak";
		windValues[1]="strong";
		explanatorySet[3] = new DiscreteAttribute("Wind",3, windValues);

		String playTennisValues[]=new String[2];
		playTennisValues[0]="yes";
		playTennisValues[1]="no";
		explanatorySet[4] = new DiscreteAttribute("PlayTennis",4, playTennisValues);
		
		
	}

	/**
	 * Restituisce cardinalità dell'insieme di transazioni
	 * @return numberOfExamples
	 */
	public int getNumberOfExamples(){
		return numberOfExamples;
	}

	/**
	 * Restituisce la dimensione di explanatorySet
	 * @return explanatorySet.length
	 */
	public int getNumberofExplanatoryAttributes(){
		return explanatorySet.length;
	}

	/**
	 * Restituisce lo schema dei dati
	 * @return explanatorySEt
	 */
	public Attribute[] getAttributeSchema(){
		return explanatorySet;
	}

	/**
	 * Restituisce il valore assunto in data dall'attributo in posizione attributeIndex, nella riga in posizione
	 * exampleIndex
	 * @param exampleIndex indice di riga matrice "data"
	 * @param attributeIndex indice di colonna matrice "data"
	 * @return data[exampleIndex][attributeIndex]
	 */
	public Object getValue(int exampleIndex, int attributeIndex){
		return data[exampleIndex][attributeIndex];
	}

	/**
	 * Restituisce il valore nell'explanatorySet all'indice indicato
	 * @param index indice
	 * @return explanatorySet[index]
	 */
	Attribute getAttribute(int index){
		return explanatorySet[index];
	}

	/**
	 * Crea una stringa in cui memorizza lo schema della tabella (explanatorySet) e le transazioni memorizzate in data
	 * opportunamente enumerate. Restituisce questa stringa
	 * @return
	 */
	public String toString(){
		String result = "";
		for(int i=0; i<explanatorySet.length-1;i++){
			result+= explanatorySet[i].getName()+",";
		}
		result += explanatorySet[explanatorySet.length-1]+"\n";

		for(int i=0;i<numberOfExamples;i++){
			result+=i+":";
			for(int j=0; j<getNumberofExplanatoryAttributes();j++){

				result+=getValue(i,j)+",";
			}
			result+="\n";


		}

		return result;
	}

	/**
	 * Crea e restituisce un oggetto di data.Tuple che modella come sequenza di coppie Attributo-valore
	 * la i-esima riga in data.
	 * @param index
	 * @return tuple
	 */
	public Tuple getItemSet(int index){
		Tuple tuple = new Tuple(explanatorySet.length);
		for(int i=0; i<explanatorySet.length;i++)
			tuple.add(new DiscreteItem((DiscreteAttribute) explanatorySet[i],(String)data[index][i]),i);
		return tuple;

	}


}
