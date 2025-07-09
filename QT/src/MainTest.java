import data.Data;
import data.EmptyDatasetException;
import mining.ClusteringRadiusException;
import mining.QTMiner;
import keyboardinput.Keyboard;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception,ClusteringRadiusException, EmptyDatasetException {
		boolean execution = true;
		double radius = 0.0;
		Keyboard keyboard = new Keyboard();

		do {
			try{
				Data data = new Data();
				System.out.println(data);

				do {
					System.out.print("Inserisci radius (>0): ");
					radius = keyboard.readDouble();
					if (radius <= 0) {
					}
				} while (radius <= 0);

				QTMiner qt=new QTMiner(radius);
				int numIter=qt.compute(data);
				System.out.println("Number of clusters:"+numIter);
				System.out.println(qt.getC().toString(data));
			} catch(ClusteringRadiusException e){
				System.out.println("Solo un cluster!");
			} catch(EmptyDatasetException e1){
				System.out.println("Il dataset risulta vuoto");
			}


			System.out.println("Vuoi ripetere l'esecuzione?(y/n)");
			char exit = keyboard.readChar();

			if(exit=='n') {
				execution = false;
			}

		}
		while(execution);

	}

}
