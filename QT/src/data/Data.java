package data;

import com.sun.source.tree.Tree;
import database.DatabaseConnectionException;
import database.DbAccess;
import database.EmptySetException;
import database.Example;

import java.sql.*;
import java.util.*;

/**
 * Classe concreta per modellare l'insieme di transazioni (o tuple o anche denominati esempi)
 */
public class Data {
	/**
	 * matrice n x m di tipo Object dove ogni riga modella una transazione descritta
	 * dagli attributi riportati sulle colonne (n: righe, m: colonne)
	 */
	private List<Example> data = new ArrayList<Example>();
	/**
	 * cardinalità dell'insieme di transazioni (numero di righe in data)
	 */
	private int numberOfExamples;
	/**
	 * Lista collegata degli attributi in ciascuna tupla (schema della tabella di dati)
	 */
	private List<Attribute> attributeSet = new LinkedList<Attribute>();

	/**
	 * Costruttore che si occupa di caricare i dati di addestramento da una tabella della base di dati.
	 * Il nome della tabella è un parametro del costruttore
	 * @param table nome tabella base di dati
	 * @throws EmptySetException
	 */
	public Data(String table) throws EmptySetException, EmptyDatasetException{
		DbAccess db = new DbAccess();

		try {
			db.initConnection();
			Connection connection = db.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultset = statement.executeQuery("SELECT * FROM "+table);
			ResultSetMetaData metaData = resultset.getMetaData();
			int columnCount = metaData.getColumnCount();
			numberOfExamples = 0;

			while (resultset.next()){
				Example example = new Example();
				// Recupera i valori delle colonne dai risultati
				String outlook = resultset.getString("Outlook");
				example.add(outlook);
				Double temperature = resultset.getDouble("Temperature");
				example.add(temperature);
				String humidity = resultset.getString("umidity");
				example.add(humidity);
				String wind = resultset.getString("Wind");
				example.add(wind);
				String playTennis = resultset.getString("play");
				example.add(playTennis);

				numberOfExamples++;
				data.add(example);
			}


		} catch (SQLException | DatabaseConnectionException e){
			e.printStackTrace();
		}

		if(numberOfExamples == 0){
			throw new EmptyDatasetException("Il dataset risulta vuoto");
		}



		TreeSet<String> outLookValues = new TreeSet<String>();
		outLookValues.add("overcast");
		outLookValues.add("rain");
		outLookValues.add("sunny");
		attributeSet.add(new DiscreteAttribute("Outlook",0, outLookValues));


		attributeSet.add(new ContinuousAttribute("Temperature",1,3.2,38.7));


		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("high");
		humidityValues.add("normal");
		attributeSet.add(new DiscreteAttribute("Humidity",2,humidityValues));

		TreeSet<String> windValues = new TreeSet<String>();
		windValues.add("weak");
		windValues.add("strong");
		attributeSet.add(new DiscreteAttribute("Wind",3,windValues));

		TreeSet<String> playTennisValues = new TreeSet<String>();
		playTennisValues.add("yes");
		playTennisValues.add("no");
		attributeSet.add(new DiscreteAttribute("PlayTennis",4,playTennisValues));

	}



	/*
	public Data() throws EmptyDatasetException{
		
		//data
		
		data = new Object [14][5];

		data[0][0] = "sunny";
		data[0][1] = new Double(30.3);
		data[0][2] = "high";
		data[0][3] = "weak";
		data[0][4] = "no";

		data[1][0] = "sunny";
		data[1][1] = new Double(30.3);
		data[1][2] = "high";
		data[1][3] = "strong";
		data[1][4] = "no";

		data[2][0] = "overcast";
		data[2][1] = new Double(30);
		data[2][2] = "high";
		data[2][3] = "weak";
		data[2][4] = "yes";

		data[3][0] = "rain";
		data[3][1] = new Double(13);
		data[3][2] = "high";
		data[3][3] = "weak";
		data[3][4] = "yes";

		data[4][0] = "rain";
		data[4][1] = new Double(0);
		data[4][2] = "normal";
		data[4][3] = "weak";
		data[4][4] = "yes";

		data[5][0] = "rain";
		data[5][1] = new Double(0);
		data[5][2] = "normal";
		data[5][3] = "strong";
		data[5][4] = "no";

		data[6][0] = "overcast";
		data[6][1] = new Double(0.1);
		data[6][2] = "normal";
		data[6][3] = "strong";
		data[6][4] = "yes";

		data[7][0] = "sunny";
		data[7][1] = new Double(13);
		data[7][2] = "high";
		data[7][3] = "weak";
		data[7][4] = "no";

		data[8][0] = "sunny";
		data[8][1] = new Double(0.1);
		data[8][2] = "normal";
		data[8][3] = "weak";
		data[8][4] = "yes";

		data[9][0] = "rain";
		data[9][1] = new Double(12);
		data[9][2] = "normal";
		data[9][3] = "weak";
		data[9][4] = "yes";

		data[10][0] = "sunny";
		data[10][1] = new Double(12.5);
		data[10][2] = "normal";
		data[10][3] = "strong";
		data[10][4] = "yes";

		data[11][0] = "overcast";
		data[11][1] = new Double(12.5);
		data[11][2] = "high";
		data[11][3] = "strong";
		data[11][4] = "yes";

		data[12][0] = "overcast";
		data[12][1] = new Double(29.21);
		data[12][2] = "normal";
		data[12][3] = "weak";
		data[12][4] = "yes";

		data[13][0] = "rain";
		data[13][1] = new Double(12.5);
		data[13][2] = "high";
		data[13][3] = "strong";
		data[13][4] = "no";


		// numberOfExamples
		
		 numberOfExamples=14;


		 if(numberOfExamples == 0){
			 throw new EmptyDatasetException("Il dataset risulta vuoto");
		 }



		TreeSet<String> outLookValues = new TreeSet<String>();
		outLookValues.add("overcast");
		outLookValues.add("rain");
		outLookValues.add("sunny");
		attributeSet.add(new DiscreteAttribute("Outlook",0, outLookValues));


		attributeSet.add(new ContinuousAttribute("Temperature",1,3.2,38.7));


		TreeSet<String> humidityValues = new TreeSet<String>();
		humidityValues.add("high");
		humidityValues.add("normal");
		attributeSet.add(new DiscreteAttribute("Humidity",2,humidityValues));

		TreeSet<String> windValues = new TreeSet<String>();
		windValues.add("weak");
		windValues.add("strong");
		attributeSet.add(new DiscreteAttribute("Wind",3,windValues));

		TreeSet<String> playTennisValues = new TreeSet<String>();
		playTennisValues.add("yes");
		playTennisValues.add("no");
		attributeSet.add(new DiscreteAttribute("PlayTennis",4,playTennisValues));
		
		
	}
	*/

	/**
	 * Restituisce cardinalità dell'insieme di transazioni
	 * @return numberOfExamples
	 */
	public int getNumberOfExamples(){
		return numberOfExamples;
	}

	/**
	 * Restituisce la dimensione di attributeSet
	 * @return attributeSet.size()
	 */
	public int getNumberofAttibuteSet(){
		return attributeSet.size();
	}

	/**
	 * Restituisce lo schema dei dati
	 * @return attributeSet
	 */
	public List<Attribute> getAttributeSchema(){
		Attribute[] result = new Attribute[getNumberofAttibuteSet()];
		result = attributeSet.toArray(result);
		return Arrays.asList(result);
	}

	/**
	 * Restituisce il valore assunto in data dall'attributo in posizione attributeIndex, nella riga in posizione
	 * exampleIndex
	 * @param exampleIndex numero di indice dell'esempio
	 * @param attributeIndex numero di indice dell'attributo
	 * @return data.get(exampleIndex).get(attributeIndex)
	 */
	public Object getValue(int exampleIndex, int attributeIndex){
		return data.get(exampleIndex).get(attributeIndex);
	}

	/**
	 * Restituisce il valore nell'attributeSet all'indice indicato
	 * @param index indice
	 * @return attributeSet.get(index)
	 */
	Attribute getAttribute(int index){
		return attributeSet.get(index);
	}

	/**
	 * Crea una stringa in cui memorizza lo schema della tabella (attributeSet) e le transazioni memorizzate in data
	 * opportunamente enumerate. Restituisce questa stringa
	 * @return result
	 */
	public String toString(){
		String result = "";
		for(int i=0; i<attributeSet.size()-1;i++){
			result+= attributeSet.get(i).getName()+",";
		}
		result += attributeSet.get(attributeSet.size()-1)+"\n";

		for(int i=0;i<numberOfExamples;i++){
			result+=i+":";
			for(int j=0; j<getNumberofAttibuteSet();j++){

				result+=getValue(i,j)+",";
			}
			result+="\n";


		}

		return result;
	}

	/**
	 * Crea un'istanza di Tuple che modelli la transazione con indice di riga index in data.
	 * Restituisce il riferimento a tale istanza. Usare lo RTTI per distinguere tra ContinuousAttribute e
	 * DiscreteAttribute (creare nella tupla un ContinuousItem o un Discrete Item)
	 *
	 * @param index
	 * @return tuple
	 */
	public Tuple getItemSet(int index){
		Tuple tuple = new Tuple(attributeSet.size());

		for(Attribute attr: attributeSet){
			if(attr instanceof ContinuousAttribute){
				tuple.add(new ContinuousItem((ContinuousAttribute)attr,(Double)getValue(index,attr.getIndex())),attr.getIndex());
			}
			if(attr instanceof DiscreteAttribute){
				tuple.add(new DiscreteItem((DiscreteAttribute) attr, (String)getValue(index,attr.getIndex())),attr.getIndex());
			}
		}

		return tuple;

	}


}
