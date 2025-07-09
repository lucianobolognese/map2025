import data.Data;
import mining.QTMiner;
import keyboardinput.Keyboard;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean execution = true;
		double radius = 0.0;
		Keyboard keyboard = new Keyboard();

		do {
			Data data = new Data();
			System.out.println(data);
			System.out.print("Inserisci radius: ");

			radius = keyboard.readDouble();

			QTMiner qt=new QTMiner(radius);
			int numIter=qt.compute(data);
			System.out.println("Number of clusters:"+numIter);
			System.out.println(qt.getC().toString(data));

			System.out.println("Vuoi ripetere l'esecuzione?(y/n)");
			char exit = keyboard.readChar();

			if(exit=='n') {
				execution = false;
			}

		}
		while(execution);

	}

}
