import data.Data;
import data.EmptyDatasetException;
import mining.ClusteringRadiusException;
import mining.QTMiner;
import keyboardinput.Keyboard;

import java.io.IOException;
import java.util.NoSuchElementException;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception,ClusteringRadiusException, EmptyDatasetException {
		boolean execution = true;
		double radius = 0.0;
		char load;
		Keyboard keyboard = new Keyboard();
		Data data = null;


		try{
			data = new Data();
		} catch(EmptyDatasetException e1){
			System.out.println("Il dataset risulta vuoto");
		}


		String filename = "./cluster.serialized.dat";

		do {
			System.out.println("Scegli una opzione\n (1) Carica Cluster da File \n (2) Carica Dati\nRisposta: ");
			load = keyboard.readChar();

			switch (load){
				case('1'):
					String risposta;
					System.out.println("Nome archivio: ");
					try {
						risposta = keyboard.readString();
						QTMiner qtminerfile = new QTMiner(risposta);

						System.out.println(qtminerfile.getC().toStringShort(data));
					} catch (IOException e) {
						// Cattura eccezioni relative all'input/output del file,
						// se QTMiner le propaga o se la lettura iniziale le causa.
						System.err.println("Errore di I/O durante il caricamento del file: " + e.getMessage());
						System.err.println("Assicurati che il nome del file sia corretto e che il file esista.");
					} catch (NoSuchElementException e) {
						// Cattura se lo scanner non ha più righe (es. input stream chiuso)
						System.err.println("Errore di input: Nessun altro dato disponibile dalla tastiera.");
						System.err.println("Riprova a scegliere l'opzione.");
						// Potresti voler chiudere lo scanner qui se questo è un errore critico
						// keyboard.close();
					} catch (Exception e) { // Cattura qualsiasi altra eccezione generica
						System.err.println("Si è verificato un errore inatteso: " + e.getMessage());
						e.printStackTrace(); // Utile per il debug
					}

					break;

				case('2'):
					try{
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

						System.out.println("Backup file name: ");
						String nomefile = keyboard.readString();
						qt.salva(nomefile);
					} catch(ClusteringRadiusException e){
						System.out.println("Solo un cluster!");
					} catch (IOException e) {
					// Cattura eccezioni relative all'input/output del file,
					// se QTMiner le propaga o se la lettura iniziale le causa.
					System.err.println("Errore di I/O durante il caricamento del file: " + e.getMessage());
					System.err.println("Assicurati che il nome del file sia corretto.");
				}

					break;
				default:
					System.out.println("Input inserito non valido");

			}




			System.out.println("Would you choose another option from the menu?(y/n)");
			char exit = keyboard.readChar();

			if(exit=='n') {
				execution = false;
			}

		}
		while(execution);

	}

}
